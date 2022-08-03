package com.warriors.model.warriors.request;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Request {
    private final RequestType requestType;
    private boolean handled;

    private Request(RequestType requestType) {
        this.requestType = Objects.requireNonNull(requestType);
    }

    public static Request create(RequestType requestType) {
        return new Request(requestType);
    }

    public void markHandled() {
        this.handled = true;
    }
}
