package com.github.brunodm2934.java.annotations.user;

public class User {

    @Validate(onlyLetters = true)
    private String login;

    @Validate
    private String password;

    private String name;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }

}
