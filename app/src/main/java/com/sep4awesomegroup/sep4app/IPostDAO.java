package com.sep4awesomegroup.sep4app;

import com.sep4awesomegroup.sep4app.common.Post;

public interface IPostDAO {
    void insert(Post post, String category);
}
