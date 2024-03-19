package org.example.domain.zsxq.model.req;
public class Req_data {

    private String text;
    private String[] image_ids = new String[]{};


    public Req_data(String text) {
        this.text = text;

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getImage_ids() {
        return image_ids;
    }

    public void setImage_ids(String[] image_ids) {
        this.image_ids = image_ids;
    }
}