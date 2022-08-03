package com.warriors.model.warriors.request;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestHandler {
    private final RequestHandler next;

    public RequestHandler(RequestHandler next) {
        this.next = next;
    }

    public void handleRequest(Request request) {
        if (next != null) {
            handleRequest(request);
        }
    }

    protected void printHandling(Request request) {
        LOGGER.info("{} handling request \"{}\"", this, request);
    }


}
