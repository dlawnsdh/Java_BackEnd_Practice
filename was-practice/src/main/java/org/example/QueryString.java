package org.example;

public class QueryString {
    private final String key;
    private final String value;

    public QueryString(String key, String value) {
        this.key = key;
        this.value =  value;
    }

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    public boolean exists(String key) {
        return this.key.equals(key);
    }
}
