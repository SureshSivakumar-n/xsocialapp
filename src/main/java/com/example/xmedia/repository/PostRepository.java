package com.example.xmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.xmedia.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}