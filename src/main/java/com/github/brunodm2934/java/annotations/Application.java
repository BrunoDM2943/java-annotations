package com.github.brunodm2934.java.annotations;


import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.jboss.weld.inject.WeldInstance;

public class Application {

    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        UserService userService = container.select(UserService.class).get();
        System.out.println(userService.sayHello("Bruno"));
    }
}
