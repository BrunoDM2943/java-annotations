package com.github.brunodm2934.java.annotations;


import com.github.brunodm2934.java.annotations.user.User;
import com.github.brunodm2934.java.annotations.user.UserService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        UserService userService = container.select(UserService.class).get();
        System.out.println(userService.sayHello("Bruno"));
        for(User user : Arrays.asList(new User(null, "123"), new User("test12", "1asdf", "Teste"))){
            try{
                userService.validateUser(user);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
