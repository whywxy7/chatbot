package org.example.test;

import com.alibaba.fastjson.JSON;
import org.example.domain.zsxq.IZsxqApi;
import org.example.domain.zsxq.model.aggregrates.UnAnsweredQuestionAggregrates;
import org.example.domain.zsxq.service.ZsxqApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @author: whywxy
 * @version: 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRunTest {
    private Logger logger = LoggerFactory.getLogger(SpringBootRunTest.class);
    @Value("${chatbot-api.groupId}")
    private String groupId;
    @Value("${chatbot-api.cookie}")
    private String cookie;

    @Resource
    private IZsxqApi zsxqApi;


    @Test
    public void zsxqApiTest()throws IOException{
        UnAnsweredQuestionAggregrates unAnsweredQuestionAggregrates = zsxqApi.queryUnansweredQuestionTopicId(groupId,cookie);
        logger.info("result:{}",JSON.toJSON(unAnsweredQuestionAggregrates));
    }
}
