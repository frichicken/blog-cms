package com.dylan.blog_cms.service;

import com.dylan.blog_cms.model.Post;
import com.dylan.blog_cms.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Post not found with id: " + id));
    }

    public Post createPost(Post post) {
        post.setPublished(false);
        return postRepository.save(post);
    }

    public Post publishPost(Long id) {
        Post post = getPostById(id);
        post.setPublished(true);
        return postRepository.save(post);
    }

    public List<Post> getPostsByCategory(String category) {
        return postRepository.findByCategory(category);
    }
}
