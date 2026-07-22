package com.dylan.blog_cms.controller;

import com.dylan.blog_cms.model.Comment;
import com.dylan.blog_cms.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts/{postId}/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getComments(@PathVariable Long postId) {
        return commentService.getCommentsByPost(postId);
    }

    @PostMapping
    public Comment addComment(@PathVariable Long postId, @RequestParam Long userId, @RequestBody String text) {
        return commentService.addComment(postId, userId, text);
    }
}
