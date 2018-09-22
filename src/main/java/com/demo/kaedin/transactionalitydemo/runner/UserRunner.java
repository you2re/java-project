package com.demo.kaedin.transactionalitydemo.runner;

import com.demo.kaedin.transactionalitydemo.model.User;
import com.demo.kaedin.transactionalitydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class UserRunner implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        try {

            userService.insert(Arrays.asList(
                    new User("Peter","IT",1200L),
                    new User("Pam","HR",1400L)));

        } catch (RuntimeException e) {
          //  System.out.println("Exceptions ... "+e.getMessage());
        }
        try {

            // new User("Josh","Fiance",2400))
            userService.insert(Arrays.asList(
                    new User("Peter","IT",1200L),
                    new User("Mike","Marketing",700L),
                    new User("Josh","Finance",2400),
                    new User("Pam","HR",1400L)
            ));

        } catch (RuntimeException e) {
            System.out.println("Exceptions ... "+e.getMessage());
        }
        System.out.println(userService.getUsers());


    }
}
