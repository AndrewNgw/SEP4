package com.sep4awesomegroup.sep4app.utility;

public class Post {
    private String authorId;
    private String content;
    private String date;

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
}
