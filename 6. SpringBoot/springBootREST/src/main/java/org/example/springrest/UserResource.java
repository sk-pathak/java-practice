package org.example.springrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserResource {
    @Autowired
    UserRepo ur;

    @GetMapping("users")
    public java.util.List<User> getUsers(){
        return (List<User>) ur.findAll();
    }

    @GetMapping(value = "users/{username}",produces = "application/json")
    public User getUser(@PathVariable(name = "username") String username){
        return ur.findById(username).orElse(new User("","",""));
//        if(ur.findById(username).isPresent()){
//            return ur.findById(username).get();
//        }
//        return null;
    }

    @PostMapping("users")
    public User createUser(@RequestBody User user){
        return ur.save(user);
    }

    @PutMapping("users")
    public User updateUser(@RequestBody User user){
        return ur.save(user);
    }

    @DeleteMapping("users/{username}")
    public void deleteUser(@PathVariable String username){
        ur.deleteById(username);
    }
}
