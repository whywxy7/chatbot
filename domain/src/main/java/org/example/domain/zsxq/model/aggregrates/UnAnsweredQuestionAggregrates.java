package org.example.domain.zsxq.model.aggregrates;

import org.example.domain.zsxq.model.res.Resp_data;

/**
 * @author: whywxy
 * @version: 1.0
 **/
public class UnAnsweredQuestionAggregrates {
    private boolean succeed;

    private Resp_data resp_data;

    public boolean isSucceed() {
        return succeed;
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }

    public Resp_data getResp_data() {
        return resp_data;
    }

    public void setResp_data(Resp_data resp_data) {
        this.resp_data = resp_data;
    }
}
