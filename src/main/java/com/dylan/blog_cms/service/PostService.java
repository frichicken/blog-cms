package com.dylan.blog_cms.service;

import com.dylan.blog_cms.dto.PostRequestDto;
import com.dylan.blog_cms.dto.PostResponseDto;
import com.dylan.blog_cms.model.Post;
import com.dylan.blog_cms.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<PostResponseDto> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    public PostResponseDto getPostById(Long id) {
        Post post = findOrThrow(id);
        return toResponseDto(post);
    }

    public PostResponseDto createPost(PostRequestDto dto) {
        Post post = new Post(dto.getTitle(), dto.getContent(), dto.getCategory());
        post.setPublished(false);
        Post saved = postRepository.save(post);
        return toResponseDto(saved);
    }

    public PostResponseDto publishPost(Long id) {
        Post post = findOrThrow(id);
        post.setPublished(true);
        Post saved = postRepository.save(post);
        return toResponseDto(saved);
    }

    public List<Post> getPostsByCategory(String category) {
        return postRepository.findByCategory(category);
    }

    private Post findOrThrow(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Post not found with id: " + id));
    }

    private PostResponseDto toResponseDto(Post post) {
        return new PostResponseDto(post.getId(), post.getTitle(), post.getContent(), post.getCategory(), post.isPublished());
    }
}
