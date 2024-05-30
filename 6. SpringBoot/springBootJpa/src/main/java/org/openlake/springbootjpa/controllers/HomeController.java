package org.openlake.springbootjpa.controllers;

import org.openlake.springbootjpa.model.User;
import org.openlake.springbootjpa.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    UserRepo repo;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("adduser")
    public String addUser(@ModelAttribute User user) {
        repo.save(user);
        return "adduser";
    }

    @PostMapping("getuser")
    public String finduser(@RequestParam(name = "username") String username, Model model) {
        model.addAttribute("users", repo.findById(username));
        return "finduser";
    }

    @PostMapping("getuserbyname")
    public String finduserbyname(@RequestParam(name="name") String name, Model model){
        model.addAttribute("users", repo.find(name));
        return "finduser";
    }

    @GetMapping("getusers")
    public String findusers(Model model) {
        model.addAttribute("users", repo.findAll());
        return "finduser";
    }

    @DeleteMapping("deleteuser")
    public String deleteUser(@RequestParam(name="username") String username) {
        repo.deleteById(username);
        return "redirect:/getusers";
    }

}
