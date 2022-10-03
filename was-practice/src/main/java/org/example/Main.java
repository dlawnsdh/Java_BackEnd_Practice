package org.example;

import java.io.IOException;

// HTTP 형식으로 웹 사칙 계산기 구현
// GET /calculate?operand1=11&operator=*&operand2=55
public class Main {
    public static void main(String[] args) throws IOException {
        new CustomWebApplicationServer(8080).start();
    }
}