package com.github.brunodm2934.java.annotations.user;

import com.github.brunodm2934.java.annotations.logger.Log;
import com.github.brunodm2934.java.annotations.user.User;

import javax.inject.Singleton;
import java.lang.reflect.Field;

@Singleton
public class UserService {

    @Log
    public String sayHello(String name) {
        return "Hello, " + name;
    }

    public void validateUser(User user) throws IllegalAccessException {
        Field[] fields = user.getClass().getDeclaredFields();
        for(Field field : fields) {
            checkFields(user, field);
        }
    }

    private void checkFields(User user, Field field) throws IllegalAccessException {
        Validate annotation = field.getAnnotation(Validate.class);
        if(annotation != null) {
            field.setAccessible(true);
            String value = (String) field.get(user);
            if (annotation.notNull() && value == null) {
                throw new IllegalArgumentException("Field " + field.getName() + " is null");
            }
            if (annotation.onlyLetters() && containsDigit(value)) {
                throw new IllegalArgumentException("Field " + field.getName() + " contains Digits");
            }
        }
    }

    private final boolean containsDigit(String s) {
        boolean containsDigit = false;

        if (s != null && !s.isEmpty()) {
            for (char c : s.toCharArray()) {
                if (containsDigit = Character.isDigit(c)) {
                    break;
                }
            }
        }

        return containsDigit;
    }
}
