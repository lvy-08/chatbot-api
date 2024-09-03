package ca.test.chatbot.api.domain.zsxq.model.res;

import ca.test.chatbot.api.domain.zsxq.model.vo.Topic;

public class Resp_data
{
    private Topic topic;

    public void setTopic(Topic topic){
        this.topic = topic;
    }
    public Topic getTopic(){
        return this.topic;
    }

}
