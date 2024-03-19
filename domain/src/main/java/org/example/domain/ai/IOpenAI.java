package org.example.domain.ai;

import java.io.IOException;

/**
 * @author: whywxy
 * @version: 1.0
 **/
public interface IOpenAI {
    String askChatgpt(String OpenAIKey,String question)throws IOException;
}
