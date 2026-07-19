package com.dylan.blog_cms.controller;

import com.dylan.blog_cms.dto.PostRequestDto;
import com.dylan.blog_cms.dto.PostResponseDto;
import com.dylan.blog_cms.model.Post;
import com.dylan.blog_cms.repository.PostRepository;
import com.dylan.blog_cms.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostResponseDto> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public PostResponseDto getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PostMapping
    public PostResponseDto createPost(@Valid @RequestBody PostRequestDto post) {
        return postService.createPost(post);
    }

    @PutMapping("/{id}/publish")
    public PostResponseDto publishPost(@PathVariable Long id) {
        return postService.publishPost(id);
    }

    @GetMapping("/category/{category}")
    public List<Post> getPostsByCategory(@PathVariable String category) {
        return postService.getPostsByCategory(category);
    }
}
