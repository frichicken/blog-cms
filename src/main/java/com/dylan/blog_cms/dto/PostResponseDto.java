package com.dylan.blog_cms.dto;

public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private String category;
    private boolean published;

    public PostResponseDto(Long id, String title, String content, String category, boolean published) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.published = published;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getCategory() { return category; }
    public boolean isPublished() { return published; }
}
