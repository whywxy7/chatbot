package org.example.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import  org.junit.Test;

import javax.swing.text.html.parser.Entity;
import java.io.Closeable;
import java.io.IOException;

/**
 * @author: whywxy
 * @version: 1.0
 **/
public class ApiTest {

    @Test
    public void query_unanswered_questions(){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");

        get.addHeader("cookie","sajssdk_2015_cross_new_user=1; zsxq_access_token=80F22D8D-B4C2-4A4F-F6C5-BC5253447D4C_996A6454E0144A51; zsxqsessionid=e78c3df018f168e5a87123737f71f289; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22185512242221242%22%2C%22first_id%22%3A%2218e52b4ebeb4e7-0ae8e4ade5bb98-4c657b58-1327104-18e52b4ebec2a7%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E5%BC%95%E8%8D%90%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fzsxq.com%2F%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThlNTJiNGViZWI0ZTctMGFlOGU0YWRlNWJiOTgtNGM2NTdiNTgtMTMyNzEwNC0xOGU1MmI0ZWJlYzJhNyIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjE4NTUxMjI0MjIyMTI0MiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22185512242221242%22%7D%2C%22%24device_id%22%3A%2218e52b4ebeb4e7-0ae8e4ade5bb98-4c657b58-1327104-18e52b4ebec2a7%22%7D");
        get.addHeader("Content-Type","application/json; charset=UTF-8\n");


        try {
            CloseableHttpResponse response = httpClient.execute(get);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String res = EntityUtils.toString(response.getEntity());
                System.out.println(res);
            } else {
                System.out.println(response.getStatusLine().getStatusCode());
            }
        }catch (IOException e){
            System.out.println("IOE");
        }
    }


    @Test
    public void answer(){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/5122142514818244/comments");

        post.addHeader("cookie","sajssdk_2015_cross_new_user=1; zsxq_access_token=80F22D8D-B4C2-4A4F-F6C5-BC5253447D4C_996A6454E0144A51; zsxqsessionid=e78c3df018f168e5a87123737f71f289; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22185512242221242%22%2C%22first_id%22%3A%2218e52b4ebeb4e7-0ae8e4ade5bb98-4c657b58-1327104-18e52b4ebec2a7%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E5%BC%95%E8%8D%90%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fzsxq.com%2F%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThlNTJiNGViZWI0ZTctMGFlOGU0YWRlNWJiOTgtNGM2NTdiNTgtMTMyNzEwNC0xOGU1MmI0ZWJlYzJhNyIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjE4NTUxMjI0MjIyMTI0MiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22185512242221242%22%7D%2C%22%24device_id%22%3A%2218e52b4ebeb4e7-0ae8e4ade5bb98-4c657b58-1327104-18e52b4ebec2a7%22%7D");
        post.addHeader("Content-Type","application/json; charset=UTF-8\n");

        String paramJSON ="{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"test2\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJSON, ContentType.create("text/JSON","UTF-8"));
        post.setEntity(stringEntity);

        try {
            CloseableHttpResponse response = httpClient.execute(post);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String res = EntityUtils.toString(response.getEntity());
                System.out.println(res);
            } else {
                System.out.println(response.getStatusLine().getStatusCode());
            }
        }catch (IOException e){
            System.out.println("IOE");
        }
    }
}
