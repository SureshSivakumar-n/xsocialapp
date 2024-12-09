package com.example.xmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.xmedia.entity.Follower;
import com.example.xmedia.entity.User;


public interface FollowerRepository extends JpaRepository<Follower, Long> {
    boolean existsByFollowerAndFollowee(User follower, User followee);
}