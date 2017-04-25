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
        while (null != userInput && !"".equals(userInput)) {
            for (int i = 0; i < 6; i++) {
                stringBuilder.append(markovGraphModel.getOneOfMostFrequentTokens(userInput));
                stringBuilder.append(" ");
            }
            break;
        }
        System.out.println(stringBuilder.toString());

    }

}

