package com.sep4awesomegroup.sep4app;

import com.sep4awesomegroup.sep4app.common.Post;
import com.sep4awesomegroup.sep4app.common.User;

public interface IModel {
    void addUser(User user);
    void addPost(Post post, String category);
    void getUser(ICallBack myCallback);
    void updateAdapter(PostsAdapter adapter, String category);
}
