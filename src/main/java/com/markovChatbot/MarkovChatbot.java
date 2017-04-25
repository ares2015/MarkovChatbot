package com.markovChatbot;

import java.util.Scanner;

/**
 * Created by Oliver on 4/25/2017.
 */
public class MarkovChatbot {

    public static void main(String[] args) {
        MarkovGraphModelFactory markovGraphModelFactory = new MarkovGraphModelFactoryImpl();
        MarkovGraphModel markovGraphModel = markovGraphModelFactory.create();
        Scanner sc = new Scanner(System.in);
        System.out.println("Start dialog with Chatbot ! ");
        String userInput = sc.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            if (null != userInput && !"".equals(userInput)) {
                for (int i = 0; i < 6; i++) {
                    stringBuilder.append(markovGraphModel.getOneOfMostFrequentTokens(userInput));
                    stringBuilder.append(" ");
                }
                System.out.println(stringBuilder.toString());
                stringBuilder.setLength(0);
                userInput = sc.nextLine();
            }
        }

    }

}

