package org.example.Component.Controller;

import org.example.Http.Request;

public abstract class Controller {
    protected Request request;

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
