package com.team3990.techportail.Models;

import java.util.Date;
import java.util.Map;

/**
 * Created by Anas Merbouh on 17-12-31.
 */

public class UserAttendanceObject {
    //
    private Date attendanceStartsAt;
    private Date attendanceEndsAt;
    private Date eventStartDate;
    private Date eventEndDate;
    private Date confirmedAt;
    private String eventTitle;
    private String eventBody;

    //
    public UserAttendanceObject(Date attendanceStartsAt, Date attendanceEndsAt, Date eventStartDate, Date eventEndDate, Date confirmedAt, String eventTitle, String eventBody) {
        this.attendanceStartsAt = attendanceStartsAt;
        this.attendanceEndsAt = attendanceEndsAt;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.confirmedAt = confirmedAt;
        this.eventTitle = eventTitle;
        this.eventBody = eventBody;
    }

    //
    public UserAttendanceObject() {}

    //
    public Date getAttendanceStartsAt() {
        return attendanceStartsAt;
    }

    public void setAttendanceStartsAt(Date attendanceStartsAt) {
        this.attendanceStartsAt = attendanceStartsAt;
    }

    public Date getAttendanceEndsAt() {
        return attendanceEndsAt;
    }

    public void setAttendanceEndsAt(Date attendanceEndsAt) {
        this.attendanceEndsAt = attendanceEndsAt;
    }

    public Date getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(Date eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public Date getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(Date eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public Date getConfirmedAt() {
        return confirmedAt;
    }

    public void setConfirmedAt(Date confirmedAt) {
        this.confirmedAt = confirmedAt;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventBody() {
        return eventBody;
    }

    public void setEventBody(String eventBody) {
        this.eventBody = eventBody;
    }
}
