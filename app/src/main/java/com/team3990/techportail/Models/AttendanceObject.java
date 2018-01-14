package com.team3990.techportail.Models;

import java.util.Date;

/**
 * Created by Anas Merbouh on 17-12-31.
 */

public class AttendanceObject {
    //
    private Date attendanceStartsAt;
    private Date attendanceEndsAt;
    private Date confirmedAt;
    private String attendantName;
    private Boolean present;

    //
    public AttendanceObject(Date attendanceStartsAt, Date attendanceEndsAt, Date confirmedAt, String attendantName, Boolean present) {
        this.attendanceStartsAt = attendanceStartsAt;
        this.attendanceEndsAt = attendanceEndsAt;
        this.confirmedAt = confirmedAt;
        this.attendantName = attendantName;
        this.present = present;
    }

    //
    public AttendanceObject() {}

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

    public Date getConfirmedAt() {
        return confirmedAt;
    }

    public void setConfirmedAt(Date confirmedAt) {
        this.confirmedAt = confirmedAt;
    }

    public String getAttendantName() {
        return attendantName;
    }

    public void setAttendantName(String attendantName) {
        this.attendantName = attendantName;
    }

    public Boolean getPresent() {
        return present;
    }

    public void setPresent(Boolean present) {
        this.present = present;
    }
}
