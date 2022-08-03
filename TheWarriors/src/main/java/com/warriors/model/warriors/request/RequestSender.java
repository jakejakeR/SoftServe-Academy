package com.warriors.model.warriors.request;

public class RequestSender {
    RequestHandler chain;

    public RequestSender buildChain(RequestHandler chain) {
        this.chain = chain;
        return this;
    }

    public RequestSender makeRequest(Request request) {
        chain.handleRequest(request);
        return this;
    }
}
