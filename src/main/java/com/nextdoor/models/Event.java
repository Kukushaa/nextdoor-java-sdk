/*
 * Copyright (c) 2024 Nika Beridze
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
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
