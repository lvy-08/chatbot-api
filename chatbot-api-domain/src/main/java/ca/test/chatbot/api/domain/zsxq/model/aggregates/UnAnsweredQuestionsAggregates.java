package ca.test.chatbot.api.domain.zsxq.model.aggregates;

import ca.test.chatbot.api.domain.zsxq.model.res.Resp_data;

public class UnAnsweredQuestionsAggregates {
    private boolean succeeded;

    private Resp_data resp_data;

    public void setSucceeded(boolean succeeded){
        this.succeeded = succeeded;
    }
    public boolean getSucceeded(){
        return this.succeeded;
    }
    public void setResp_data(Resp_data resp_data){
        this.resp_data = resp_data;
    }
    public Resp_data getResp_data(){
        return this.resp_data;
    }
}
