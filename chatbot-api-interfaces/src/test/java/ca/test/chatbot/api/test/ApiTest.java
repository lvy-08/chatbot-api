package ca.test.chatbot.api.test;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class ApiTest {
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get=new HttpGet("https://api.zsxq.com/v2/topics/8855184452854882/info");
        get.addHeader("cookie","zsxq_access_token=B24596A6-1105-B084-076E-4AC0ADC775C6_353DDC4948A48135; zsxqsessionid=11e1c62b9e7734f4acc90cad27435621; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22212844111555851%22%2C%22first_id%22%3A%2219150bac03e3db-0d88768dbb07ef8-26001e51-1327104-19150bac03f71c%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTkxNTBiYWMwM2UzZGItMGQ4ODc2OGRiYjA3ZWY4LTI2MDAxZTUxLTEzMjcxMDQtMTkxNTBiYWMwM2Y3MWMiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIyMTI4NDQxMTE1NTU4NTEifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22212844111555851%22%7D%2C%22%24device_id%22%3A%2219150c2755c63e-055698f7c860144-26001e51-1327104-19150c2755dcd7%22%7D; abtest_env=product");
        get.addHeader("Content-Type","application/json;charset=utf8");
        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post=new HttpPost("https://api.zsxq.com/v2/topics/2855184214882211/comments?sort=asc&count=30&with_sticky=true");
        post.addHeader("cookie","zsxq_access_token=B24596A6-1105-B084-076E-4AC0ADC775C6_353DDC4948A48135; zsxqsessionid=11e1c62b9e7734f4acc90cad27435621; abtest_env=product; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22212844111555851%22%2C%22first_id%22%3A%2219150bac03e3db-0d88768dbb07ef8-26001e51-1327104-19150bac03f71c%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTkxNTBiYWMwM2UzZGItMGQ4ODc2OGRiYjA3ZWY4LTI2MDAxZTUxLTEzMjcxMDQtMTkxNTBiYWMwM2Y3MWMiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIyMTI4NDQxMTE1NTU4NTEifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22212844111555851%22%7D%2C%22%24device_id%22%3A%2219150c2755c63e-055698f7c860144-26001e51-1327104-19150c2755dcd7%22%7D");
        post.addHeader("Content-Type","application/json;charset=utf8");

        String paramJson="{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"自己去百度！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";
        StringEntity stringEntity=new StringEntity(paramJson, ContentType.create("text/json","utf-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
             String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
    @Test
    public void test_chatGPT() throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.chatanywhere.tech/v1/chat/completions");
        post.addHeader("Content-Type","application/json");
        post.addHeader("Authorization","Bearer sk-yjW9IB9iHjvON2eY9klEd3zLDnPid2ECJktmzaykIzrnsass");
        String paramJson="{\n" +
                "   \"model\": \"gpt-3.5-turbo\",\n" +
                "   \"messages\": [{\"role\": \"user\", \"content\": \"请帮我用Java写一个冒泡排序!\"}],\n" +
                "   \"temperature\": 0.7\n" +
                " }";
        StringEntity stringEntity=new StringEntity(paramJson, ContentType.create("text/json","utf-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
