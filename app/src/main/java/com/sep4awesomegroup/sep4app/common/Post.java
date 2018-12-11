package com.sep4awesomegroup.sep4app.common;

import java.util.Objects;

public class Post {
    private String authorId;
    private String content;
    private String date;

    public Post(){

    }

    public Post(String authorId, String content, String date) {
        this.authorId = authorId;
        this.content = content;
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthorId() {
        return authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(authorId, post.authorId) &&
                Objects.equals(content, post.content) &&
                Objects.equals(date, post.date);
    }
}
