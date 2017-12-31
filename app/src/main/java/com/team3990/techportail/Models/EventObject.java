package com.team3990.techportail.Models;

import android.util.EventLog;

import java.util.Date;
import java.util.Map;

/**
 * Created by Anas Merbouh on 17-12-30.
 */

public class EventObject {
    //
    private String title;
    private String body;
    private Map<String, String> author;
    private Date startDate;
    private Date endDate;
    private Date timestamp;

    //
    public EventObject(String title, String body, Map<String, String> author, Date startDate, Date endDate, Date timestamp) {
        this.title = title;
        this.body = body;
        this.author = author;
        this.startDate = startDate;
        this.endDate = endDate;
        this.timestamp = timestamp;
    }

    //
    public EventObject() {};

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
