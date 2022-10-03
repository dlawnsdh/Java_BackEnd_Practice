package org.example;

public class User {
    private String password;

    public void initPassword(PasswordGenerator passwordGenerator) {
        String password = passwordGenerator.generatePassword();
        int len = password.length();

        if (len >= 8 && len <= 12)
            this.password = password;
    }

    public String getPassword() {
        return password;
    }

}
