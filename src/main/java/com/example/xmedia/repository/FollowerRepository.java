package com.example.xmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.xmedia.entity.Follower;

public interface FollowerRepository extends JpaRepository<Follower, Long> {
}