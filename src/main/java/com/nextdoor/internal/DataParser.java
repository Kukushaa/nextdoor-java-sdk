package com.nextdoor.internal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class DataParser {
    private final ObjectMapper objectMapper = makeDefaultObjectMapper();

    public <T> T parseToObject(String from, Class<T> tClass) throws DataParserException {
        try {
            return parse(from, tClass);
        } catch (Exception e) {
            throw new DataParserException("Cannot parse data " + from, e);
        }
    }

    public <T> List<T> parseToList(String jsonString, Class<T> responseClass) throws DataParserException {
        try {
            return objectMapper.readValue(jsonString, objectMapper.getTypeFactory().constructCollectionType(List.class, responseClass));
        } catch (Exception e) {
            throw new DataParserException("Error parsing JSON to list: " + e.getMessage(), e);
        }
    }

    public String convertObjectToJsonString(Object object) throws DataParserException {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new DataParserException("Cannot parse object to JSON String - " + object, e);
        }
    }

    private <T> T parse(String from, Class<T> tClass) throws Exception {
        return objectMapper.readValue(from, tClass);
    }

    private static ObjectMapper makeDefaultObjectMapper() {
        return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static class DataParserException extends Exception {
        public DataParserException() {
        }

        public DataParserException(String s) {
            super(s);
        }

        public DataParserException(String s, Throwable throwable) {
            super(s, throwable);
        }

        public DataParserException(Throwable throwable) {
            super(throwable);
        }

        public DataParserException(String s, Throwable throwable, boolean b, boolean b1) {
            super(s, throwable, b, b1);
        }
    }
}
