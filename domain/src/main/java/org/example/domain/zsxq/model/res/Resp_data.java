
package org.example.domain.zsxq.model.res;
import org.example.domain.zsxq.model.vo.Topics;

import java.util.List;


public class Resp_data {

    private List<Topics> topics;
    public void setTopics(List<Topics> topics) {
         this.topics = topics;
     }
     public List<Topics> getTopics() {
         return topics;
     }

}