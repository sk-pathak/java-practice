package org.openlake.springproject.controller;

import org.openlake.springproject.model.User;
import org.openlake.springproject.repository.SearchRepoImpl;
import org.openlake.springproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepo repo;

    @Autowired
    SearchRepoImpl searchRepo;

    @PostMapping("user")
    public User addUser(@RequestBody User user) {
        return repo.save(user);
    }

    @GetMapping("users")
    public List<User> getUsers() {
        return repo.findAll();
    }

    @GetMapping("users/{user}")
    public User getUser(@PathVariable("user") String username) {
        return repo.findById(username).orElse(null);
    }

    @GetMapping("search/{text}")
    public List<User> getUserByText(@PathVariable("text") String text) {
        return searchRepo.findByText(text);
    }

    @DeleteMapping("users/{user}")
    public void deleteUser(@PathVariable("user") String username) {
        repo.deleteById(username);
    }
}
