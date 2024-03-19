package org.example.domain.zsxq;

import org.example.domain.zsxq.model.aggregrates.UnAnsweredQuestionAggregrates;

import java.io.IOException;

/**
 * @author: whywxy
 * @version: 1.0
 **/
public interface IZsxqApi {
    UnAnsweredQuestionAggregrates queryUnansweredQuestionTopicId(String groupId, String cookie)throws IOException;

    boolean answer(String groupId,String cookie,String topicId, String text)throws IOException;
}
