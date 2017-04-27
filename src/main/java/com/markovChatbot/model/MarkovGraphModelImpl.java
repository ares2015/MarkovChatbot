package com.markovChatbot.model;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * Created by Oliver on 4/25/2017.
 */
public final class MarkovGraphModelImpl implements MarkovGraphModel {

    private Map<String, TreeMap<Integer, List<String>>> graph;

    private Random random = new Random();

    public MarkovGraphModelImpl(Map<String, TreeMap<Integer, List<String>>> graph) {
        this.graph = graph;
    }

    public String getOneOfMostFrequentTokens(String token) {
        Map.Entry<Integer, List<String>> integerListEntry = graph.get(token).lastEntry();
        List<String> tokens = integerListEntry.getValue();
        if (tokens.size() == 1) {
            return tokens.get(0);
        } else {
            return tokens.get(random.nextInt(tokens.size()));
        }
    }
}
