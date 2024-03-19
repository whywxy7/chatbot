package org.example.domain.zsxq.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.example.domain.zsxq.IZsxqApi;
import org.example.domain.zsxq.model.aggregrates.UnAnsweredQuestionAggregrates;
import org.example.domain.zsxq.model.req.AnswerReq;
import org.example.domain.zsxq.model.req.Req_data;
import org.example.domain.zsxq.model.res.AnswerRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author: whywxy
 * @version: 1.0
 **/
@Service
public class ZsxqApi implements IZsxqApi {

    private Logger logger = LoggerFactory.getLogger(ZsxqApi.class);
    @Override
    public UnAnsweredQuestionAggregrates queryUnansweredQuestionTopicId(String groupId, String cookie) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/"+groupId+"/topics?scope=all&count=20");

        get.addHeader("cookie",cookie);
        get.addHeader("Content-Type","application/json; charset=UTF-8\n");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String jsonStr = EntityUtils.toString(response.getEntity());
            logger.info("questiontext:groupId:{},jsonStr{}",groupId,jsonStr);
            return JSON.parseObject(jsonStr, UnAnsweredQuestionAggregrates.class);
        } else {
            throw new RuntimeException("Topic err code is: "+response.getStatusLine().getStatusCode());
        }
    }

    @Override
    public boolean answer(String groupId, String cookie, String topicId, String text) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/"+topicId+"/comments");

        post.addHeader("cookie",cookie);
        post.addHeader("Content-Type","application/json; charset=UTF-8\n");
        post.addHeader("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36 Edg/122.0.0.0");

        AnswerReq answerReq =new AnswerReq(new Req_data(text));
        String paramJson = JSONObject.toJSONString(answerReq);

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/JSON","UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String jsonStr = EntityUtils.toString(response.getEntity());
            AnswerRes tmp = JSONObject.parseObject(jsonStr, AnswerRes.class);
            logger.info("Answers:groupId:{}, topicId:{},jsonStr{}",groupId,topicId,jsonStr);
            return tmp.isSucceed();
        } else {
            throw new RuntimeException("Topic err code is: "+response.getStatusLine().getStatusCode());
        }
    }
}
