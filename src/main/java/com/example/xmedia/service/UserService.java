package com.example.xmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.xmedia.repository.*;
import com.example.xmedia.entity.*;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FollowerRepository followerRepository;

    @Autowired
    private PostRepository postRepository;

    public User registerUser(String name) {
        User user = new User();
        user.setName(name);
        return userRepository.save(user);
    }

    public void followUser(Long followerId, Long followeeId) {
        User follower = userRepository.findById(followerId).orElseThrow(() -> new IllegalArgumentException("Follower not found"));
        User followee = userRepository.findById(followeeId).orElseThrow(() -> new IllegalArgumentException("Followee not found"));

        if (followerId.equals(followeeId)) {
            throw new IllegalArgumentException("A user cannot follow themselves");
        }

        if (followerRepository.existsByFollowerAndFollowee(follower, followee)) {
            throw new IllegalStateException("Already following this user");
        }

        Follower relationship = new Follower();
        relationship.setFollower(follower);
        relationship.setFollowee(followee);

        followerRepository.save(relationship);
    }

    public Post postMessage(Long userId, String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be empty");
        }

        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Post post = new Post();
        post.setUser(user);
        post.setMessage(message);
        return postRepository.save(post);
    }
}
