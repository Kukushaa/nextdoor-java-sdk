package com.nextdoor.models;

public enum ContentType {
    WEATHER,
    FIND_A_SERVICE,
    REPORT_LOST_ITEMS,
    REPORT_FOUND_ITEMS,
    URGENT;

    public ContentType getDefaultContentType() {
        return ContentType.FIND_A_SERVICE;
    }
}
