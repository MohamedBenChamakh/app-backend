package com.example.app.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Post {

    @Id
    private String id;
    private String title;
    private String content;
    private Date createdAt;

    public Post() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
