package com.team3990.techportail.Models;

import java.util.Date;
import java.util.Map;

/**
 * Created by Anas Merbouh on 17-12-30.
 */

public class NewObject {
    //
    private String title;
    private String body;
    private Map<String, String> author;
    private Date timestamp;

    //
    public NewObject(String title, String body, Map<String, String> author, Date timestamp) {
        this.title = title;
        this.body = body;
        this.author = author;
        this.timestamp = timestamp;
    }

    //
    public NewObject() {};

    //
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, String> getAuthor() {
        return author;
    }

    public void setAuthor(Map<String, String> author) {
        this.author = author;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
