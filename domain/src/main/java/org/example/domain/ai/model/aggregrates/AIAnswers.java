package org.example.domain.ai.model.aggregrates;

import org.example.domain.ai.model.vo.Choices;

import java.util.List;

/**
 * @author: whywxy
 * @version: 1.0
 **/
public class AIAnswers {
    private String id;

    private String object;

    private int created;

    private String model;

    private List<Choices> choices;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Choices> getChoices() {
        return choices;
    }

    public void setChoices(List<Choices> choices) {
        this.choices = choices;
    }
}
