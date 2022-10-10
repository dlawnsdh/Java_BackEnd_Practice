package org.example.webapplicationserver;

import org.example.calculator.Calculator;
import org.example.calculator.calculate.PositiveNumber;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ClientRequestHandler implements Runnable{
    @Override
    public void run() {
        try (InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()) {
            BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
            DataOutputStream dos = new DataOutputStream(out);

            HttpRequest httpRequest = new HttpRequest(br);

            if (httpRequest.isGetRequest() && httpRequest.matchPath("/calculate")) {
                QueryStrings queryStrings = httpRequest.getQueryString();

                int operand1 = Integer.parseInt(queryStrings.getValue("operand1"));
                String operator = (queryStrings.getValue("operator"));
                int operand2 = Integer.parseInt(queryStrings.getValue("operand2"));

                int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

                HttpResponse response = new HttpResponse(dos);
                byte[] body = String.valueOf(result).getBytes();
                response.response200Header("application/json", body.length);
                response.responseBody(body);
            }
        }
    }
}
