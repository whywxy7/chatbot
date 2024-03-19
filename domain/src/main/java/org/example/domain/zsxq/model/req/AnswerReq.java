package org.example.domain.zsxq.model.req;

/**
 * @author: whywxy
 * @version: 1.0
 **/
public class AnswerReq {
    private Req_data reqData;

    public AnswerReq(Req_data reqData) {
        this.reqData = reqData;
    }

    public Req_data getReqData() {
        return reqData;
    }

    public void setReqData(Req_data reqData) {
        this.reqData = reqData;
    }
}
