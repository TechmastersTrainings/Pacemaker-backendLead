package com.prasad.pacemaker.dto;

import java.time.LocalDateTime;

public class LiveClassRequest {

    private String title;

    private String description;

    private LocalDateTime startTime;

    private String meetingLink;

    public LiveClassRequest() {
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getMeetingLink() {
        return meetingLink;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setMeetingLink(String meetingLink) {
        this.meetingLink = meetingLink;
    }
}