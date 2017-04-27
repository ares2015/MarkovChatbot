package com.markovChatbot;

import com.markovChatbot.factory.MarkovGraphModelFactory;
import com.markovChatbot.factory.MarkovGraphModelFactoryImpl;
import com.markovChatbot.model.MarkovGraphModel;

import java.util.Scanner;

/**
 * Created by Oliver on 4/25/2017.
 */
public class MarkovChatbot {

    public static void main(String[] args) {
        MarkovGraphModelFactory markovGraphModelFactory = new MarkovGraphModelFactoryImpl();

        MarkovGraphModel bigramGraphModel = markovGraphModelFactory.create("c:\\Users\\Oliver\\Documents\\NlpTrainingData\\MarkovChatbot\\MarkovBigramChatbotModel.txt");
        MarkovGraphModel trigramGraphModel = markovGraphModelFactory.create("c:\\Users\\Oliver\\Documents\\NlpTrainingData\\MarkovChatbot\\MarkovTrigramChatbotModel.txt");

        Scanner sc = new Scanner(System.in);
        System.out.println("Start dialog with Chatbot ! ");
        String userInput = sc.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            if (null != userInput && !"".equals(userInput)) {
                for (int i = 0; i < 6; i++) {
                    stringBuilder.append(bigramGraphModel.getOneOfMostFrequentTokens(userInput));
                    stringBuilder.append(" ");
                }
                System.out.println(stringBuilder.toString());
                stringBuilder.setLength(0);
                userInput = sc.nextLine();
            }
        }

    }

}

