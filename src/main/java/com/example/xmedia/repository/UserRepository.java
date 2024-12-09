package com.example.xmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.xmedia.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}