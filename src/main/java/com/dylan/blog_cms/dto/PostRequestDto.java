package com.dylan.blog_cms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PostRequestDto {
    @NotBlank(message = "Title is required")
    @Size(max = 200, message = "Title must be under 200 characters")
    private String title;

    @NotBlank(message = "Content is required")
    private String content;

    @NotBlank(message = "Category is required")
    private String category;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
