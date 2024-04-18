package org.example.Http;


import com.sun.net.httpserver.HttpExchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Request {
    private final HttpExchange exchange;
    private final Map<String, String> headers;
    private Map<String, String> queryParams;
    private String param;
    private String body;
    private String method;
    private URI url;

    public Request(HttpExchange exchange) {
        this.exchange = exchange;
        this.headers = parseHeaders(exchange);
        this.param = extractPathParam(exchange);
        this.body = parseBody(exchange);
        this.queryParams = parseQueryParams(exchange);
        this.parseMethod();
    }

    private void parseMethod() {
        this.method = exchange.getRequestMethod();
    }

    private Map<String, String> parseHeaders(HttpExchange exchange) {
        Map<String, String> headers = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : exchange.getRequestHeaders().entrySet()) {
            headers.put(entry.getKey(), entry.getValue().getFirst());
        }
        return headers;
    }


    private String parseBody(HttpExchange exchange) {
        try (InputStream inputStream = exchange.getRequestBody()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    private Map<String, String> parseQueryParams(HttpExchange exchange) {
        Map<String, String> queryParams = new HashMap<>();
        this.url = exchange.getRequestURI();
        String query = url.getQuery();
        if (query != null) {
            String[] pairs = query.split("&");
            for (String pair : pairs) {
                String[] keyValue = pair.split("=");
                if (keyValue.length == 2) {
                    String key = keyValue[0];
                    String value;
                    value = java.net.URLDecoder.decode(keyValue[1], StandardCharsets.UTF_8);
                    queryParams.put(key, value);
                }
            }
        }
        return queryParams;
    }

    private String extractPathParam(HttpExchange exchange) {
        URI requestURI = exchange.getRequestURI();
        String path = requestURI.getPath();
        String[] segments = path.split("/");
        if (segments.length > 2) {
            return segments[segments.length - 1];
        } else {
            return null;
        }
    }

    public HttpExchange getExchange() {
        return exchange;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public String getBody() {
        return body;
    }

    public String getMethod() {
        return method;
    }


    public URI getUrl() {
        return url;
    }

    public String getParam() {
        return param;
    }
}
