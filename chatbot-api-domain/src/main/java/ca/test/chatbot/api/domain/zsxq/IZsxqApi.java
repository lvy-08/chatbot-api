package ca.test.chatbot.api.domain.zsxq;

import ca.test.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;

import java.io.IOException;

public interface IZsxqApi {
    UnAnsweredQuestionsAggregates queryUnAnsweredQuestionsTopicId(String topicId,String cookie) throws IOException;
    boolean answer(String groupId,String cookie,String topicId,String text,boolean silenced) throws IOException;
}
