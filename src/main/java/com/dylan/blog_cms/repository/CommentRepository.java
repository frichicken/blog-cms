package com.dylan.blog_cms.repository;

import com.dylan.blog_cms.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);

    List<Comment> findByAuthorId(Long userId);
}
