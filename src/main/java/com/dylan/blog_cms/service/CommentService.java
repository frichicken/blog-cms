package com.dylan.blog_cms.service;

import com.dylan.blog_cms.model.Comment;
import com.dylan.blog_cms.model.Post;
import com.dylan.blog_cms.model.User;
import com.dylan.blog_cms.repository.CommentRepository;
import com.dylan.blog_cms.repository.PostRepository;
import com.dylan.blog_cms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CommentService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    public Comment addComment(Long postId, Long userId, String text) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new NoSuchElementException("Post not found: " + postId));
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("User not found: " + userId));

        Comment comment = new Comment(text, post, user);
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByPost(Long postId) {
        return commentRepository.findByPostId(postId);
    }
}
