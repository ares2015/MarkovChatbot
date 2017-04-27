package com.markovChatbot.factory;

import com.markovChatbot.model.MarkovGraphModel;
import com.markovChatbot.model.MarkovGraphModelImpl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Oliver on 4/25/2017.
 */
public class MarkovGraphModelFactoryImpl implements MarkovGraphModelFactory {

    public MarkovGraphModel create(String path) {
        Map<String, TreeMap<Integer, List<String>>> graph = new HashMap<String, TreeMap<Integer, List<String>>>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String modelDataRow = br.readLine();
            while (modelDataRow != null) {
                if (!"".equals(modelDataRow)) {
                    String[] split1 = modelDataRow.split(">>>>>");
                    String keyToken = split1[0];
                    String[] split2 = split1[1].split("#");
                    int tokenIndex = 0;
                    for (String split2String : split2) {
                        int frequency = 0;
                        if (!"".equals(split2String)) {
                            String[] tokens = split2String.split("@");
                            for (String token : tokens) {
                                if (tokenIndex == 0) {
                                    frequency = Integer.valueOf(token);
                                    tokenIndex++;
                                } else {
                                    if (graph.containsKey(keyToken)) {
                                        if (graph.get(keyToken).containsKey(frequency)) {
                                            graph.get(keyToken).get(frequency).add(token);
                                        } else {
                                            List<String> tokensList = new ArrayList<String>();
                                            tokensList.add(token);
                                            graph.get(keyToken).put(frequency, tokensList);
                                        }
                                    } else {
                                        List<String> tokensList = new ArrayList<String>();
                                        tokensList.add(token);
                                        TreeMap<Integer, List<String>> treeMap = new TreeMap<Integer, List<String>>();
                                        treeMap.put(frequency, tokensList);
                                        graph.put(keyToken, treeMap);
                                    }
                                }
                            }
                        }
                    }
                }
                modelDataRow = br.readLine();
            }
        } catch (
                final IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }
        return new MarkovGraphModelImpl(graph);
    }


}