package com.markovChatbot.model;

/**
 * Created by Oliver on 4/25/2017.
 */
public interface MarkovGraphModel {

    String getOneOfMostFrequentTokens(String token);

}