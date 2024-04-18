package org.example.Component.Controller;

import org.example.Component.Interface.IRequest;
import org.example.Http.Request;

public abstract class Controller implements IRequest {
    protected Request request;

    public Request getRequest() {
        return request;
    }

    @Override
    public void setRequest(Request request) {
        this.request = request;
    }
}
