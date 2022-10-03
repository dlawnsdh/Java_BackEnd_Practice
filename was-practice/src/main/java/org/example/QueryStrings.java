package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryStrings {
    private List<QueryString> queryStrings = new ArrayList<>();
    // QueryString : operand1=11&operator=*&operand2=55
    public QueryStrings(String queryStringLine) {
        String[] queryStringTokens = queryStringLine.split("&"); // [operand1=11, operator=*, operand2=55]
        Arrays.stream(queryStringTokens)
                .forEach(queryString -> {
                    String[] values = queryString.split("="); // "[operand1, 11], [operator, *], [operand2, 55]"
                    if (values.length != 2)
                        throw new IllegalArgumentException("잘못된 QueryString 포맷을 가진 문자열");
                    queryStrings.add(new QueryString(values[0], values[1])); // operand1, 11
                });

        /*for (int i = 0; i < queryStrings.size(); i++) {
            System.out.println(queryStrings.get(i).getKey() + " " + queryStrings.get(i).getValue());
        }*/
    }

    public String getValue(String key) {
        return queryStrings.stream()
                .filter(queryString -> queryString.exists(key))
                .map(QueryString::getValue)
                .findFirst()
                .orElse(null);
    }
}
