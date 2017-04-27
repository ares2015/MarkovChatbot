package com.markovChatbot.factory;

import com.markovChatbot.model.MarkovGraphModel;

/**
 * Created by Oliver on 4/25/2017.
 */
public interface MarkovGraphModelFactory {

    MarkovGraphModel create(String path);

}
