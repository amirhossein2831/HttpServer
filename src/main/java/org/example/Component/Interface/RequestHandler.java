package org.example.Component.Interface;

import org.example.Http.Request;

import java.io.IOException;

public interface RequestHandler {
    void handle(Request request) throws IOException;

}
