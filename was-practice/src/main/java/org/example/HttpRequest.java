package org.example;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpRequest {
    private final RequestLine requestLine;

    public HttpRequest(BufferedReader br) throws IOException {
        this.requestLine = new RequestLine(br.readLine());
    }

    public boolean isGetRequest() {
        return requestLine.isGetRequest();
    }

    public boolean matchUrlPath(String requestPath) {
        return requestLine.matchUrlPath(requestPath);
    }

    public QueryStrings GetQueryString() {
        return requestLine.getQueryStrings();
    }
}
