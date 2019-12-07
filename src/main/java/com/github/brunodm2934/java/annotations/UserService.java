package com.github.brunodm2934.java.annotations;

import com.github.brunodm2934.java.annotations.logger.Log;

import javax.inject.Singleton;

@Singleton
public class UserService {

    @Log
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
