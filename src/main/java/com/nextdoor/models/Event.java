package com.nextdoor.models;

import java.time.LocalDateTime;

public class Event extends NextDoorURLEncodedModel {
    private String title;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String covertPhoto;
    private String virtualEventLink;

    public Event() {

    }

    public Event(String title, String description, LocalDateTime startTime, LocalDateTime endTime, String covertPhoto, String virtualEventLink) {
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.covertPhoto = covertPhoto;
        this.virtualEventLink = virtualEventLink;
    }

    public static EventBuilder create() {
        return new EventBuilder(new Event());
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

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getCovertPhoto() {
        return covertPhoto;
    }

    public String getVirtualEventLink() {
        return virtualEventLink;
    }

    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", covertPhoto='" + covertPhoto + '\'' +
                ", virtualEventLink='" + virtualEventLink + '\'' +
                '}';
    }

    public static class EventBuilder {
        private final Event event;

        public EventBuilder(Event event) {
            this.event = event;
        }

        public EventBuilder setTitle(String title) {
            this.event.title = title;
            return this;
        }

        public EventBuilder setDescription(String description) {
            this.event.description = description;
            return this;
        }

        public EventBuilder setStartTime(LocalDateTime startTime) {
            this.event.startTime = startTime;
            return this;
        }

        public EventBuilder setEndTime(LocalDateTime endTime) {
            this.event.endTime = endTime;
            return this;
        }

        public EventBuilder setCovertPhoto(String covertPhoto) {
            this.event.covertPhoto = covertPhoto;
            return this;
        }

        public EventBuilder setVirtualEventLink(String virtualEventLink) {
            this.event.virtualEventLink = virtualEventLink;
            return this;
        }

        public Event build() {
            return event;
        }
    }
}
