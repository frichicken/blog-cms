package com.dylan.blog_cms.repository;

import com.dylan.blog_cms.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByCategory(String category);
    List<Post> findByPublishedTrue();
    List<Post> findByTitleContainingIgnoreCase(String title);
}
