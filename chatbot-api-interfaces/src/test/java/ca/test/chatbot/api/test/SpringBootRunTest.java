package ca.test.chatbot.api.test;

import ca.test.chatbot.api.domain.ai.IOpenAI;
import ca.test.chatbot.api.domain.zsxq.IZsxqApi;
import ca.test.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import ca.test.chatbot.api.domain.zsxq.model.vo.Topic;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRunTest {
    Logger logger= LoggerFactory.getLogger(SpringRunner.class);
//    @Value("${chatbot-api.groupId}")
//    private String groupId;
    @Value("${chatbot-api.topicId}")
    private String topicId;
    @Value("${chatbot-api.cookie}")
    private String cookie;

    @Resource
    private IZsxqApi zsxqApi;
    @Resource
    private IOpenAI openAI;

    @Test
    public void test_zsxqApi() throws IOException {
        UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqApi.queryUnAnsweredQuestionsTopicId(topicId, cookie);
        logger.info("测试结果：{}", JSON.toJSONString(unAnsweredQuestionsAggregates));
        Topic topic=unAnsweredQuestionsAggregates.getResp_data().getTopic();
        String topicId = topic.getTopic_id();
        String text = topic.getTalk().getText();
        logger.info("topicId:{} text:{}",topicId,text);
    }
    @Test
    public void test_openAi() throws IOException {
        String response = openAI.doChatGPT("帮我写一个java冒泡排序");
        logger.info("测试结果: {}",response);
    }
}
