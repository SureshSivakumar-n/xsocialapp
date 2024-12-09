package com.example.xmedia.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.xmedia.entity.Post;
import com.example.xmedia.entity.User;
import com.example.xmedia.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestParam String name) {
        return userService.registerUser(name);
    }

    @PostMapping("/{id}/follow")
    public void followUser(@PathVariable Long id, @RequestParam Long followeeId) {
        userService.followUser(id, followeeId);
    }

    @PostMapping("/{id}/posts")
    public Post postMessage(@PathVariable Long id, @RequestParam String message) {
        return userService.postMessage(id, message);
    }
}