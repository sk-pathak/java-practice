package org.example.springjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcApplication {

    public static void main(String[] args) {
        ApplicationContext context=SpringApplication.run(SpringJdbcApplication.class, args);
        User user=context.getBean(User.class);
        UserRepo ur=context.getBean(UserRepo.class);

//        user.setName("Sumit1");
//        user.setUsername("skp1");
//        user.setPassword("1");
//        System.out.println(ur.insertUser(user)+" row/s affected");

        System.out.println(ur.getAllUsers());

//        System.out.println(ur.getUser("dlwlrma"));

//        System.out.println(ur.deleteUser("skp1")+" user/s deleted");
    }

}
