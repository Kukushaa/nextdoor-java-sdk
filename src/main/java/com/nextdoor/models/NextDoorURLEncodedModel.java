package com.nextdoor.models;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.StringJoiner;

public abstract class NextDoorURLEncodedModel {
    public String toUrlEncodedString() throws IllegalAccessException, UnsupportedEncodingException {
        StringJoiner stringJoiner = new StringJoiner("&");
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            String key = field.getName();
            Object value = field.get(this);
            if (value != null) {
                stringJoiner.add(URLEncoder.encode(key, "UTF-8") + "=" + URLEncoder.encode(value.toString(), "UTF-8"));
            }
        }
        return stringJoiner.toString();
    }
}
