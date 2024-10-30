package com.nextdoor.auth;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class NextDoorAPIAuth {
    private String token;
    private boolean debug = true;
    private PrintStream logger;

    public NextDoorAPIAuth() {

    }

    public NextDoorAPIAuth(String token) {
        this.token = token;
    }

    public NextDoorAPIAuth(String token, boolean debug) {
        this.token = token;
        this.debug = debug;
    }

    public NextDoorAPIAuth(String token, boolean debug, PrintStream logger) {
        this.token = token;
        this.debug = debug;
        this.logger = logger;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isDebug() {
        return debug;
    }

    public NextDoorAPIAuth enableDebug(boolean debug) {
        this.debug = debug;

        return this;
    }

    public PrintStream getLogger() {
        return logger;
    }

    public NextDoorAPIAuth setLogger(PrintStream logger) {
        this.logger = logger;

        return this;
    }

    public void log(String message) {
        if (this.debug && logger != null) {
            this.logger.println(message);
        } else if (this.debug) {
            System.out.println(message);
        }
    }

    public void log(String message, Object... objects) {
        for (int index = 0; index < objects.length; index++) {
            message = message.replace("{" + index + "}", objects[index].toString());
        }

        log(message);
    }

    public Map<String, String> getTokenHeader() {
        Map<String, String> header = new HashMap<>();

        header.put("authorization", "Bearer " + this.token);

        return header;
    }

    public static NextDoorAPIAuth defaultNextDoorAPIAuth() {
        return new NextDoorAPIAuth();
    }
}