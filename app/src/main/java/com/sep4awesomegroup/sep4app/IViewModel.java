package com.sep4awesomegroup.sep4app;

import com.sep4awesomegroup.sep4app.common.User;

public interface IViewModel {
    void addUser(User user);
    void addPost(String content, String date, String category);
    void getUser(ICallBack myCallback);
    void updateAdapter(PostsAdapter adapter, String category);
}
