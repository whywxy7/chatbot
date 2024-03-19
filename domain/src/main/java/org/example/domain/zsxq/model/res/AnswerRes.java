package org.example.domain.zsxq.model.res;

/**
 * @author: whywxy
 * @version: 1.0
 **/
public class AnswerRes {
    boolean isSucceed;

    public AnswerRes(boolean isSucceed) {
        this.isSucceed = isSucceed;
    }

    public boolean isSucceed() {
        return isSucceed;
    }

    public void setSucceed(boolean succeed) {
        isSucceed = succeed;
    }
}
