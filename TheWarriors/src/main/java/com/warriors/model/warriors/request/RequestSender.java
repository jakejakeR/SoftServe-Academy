package com.warriors.model.warriors.request;

import com.warriors.model.Army;

public class RequestSender extends Army {
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
