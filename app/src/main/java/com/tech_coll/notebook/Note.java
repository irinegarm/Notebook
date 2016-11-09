package com.tech_coll.notebook;

import java.io.Serializable;

/**
 * Created by Admin on 27.10.2016.
 */

public class Note implements Serializable {
    private String title;

    private String content;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
