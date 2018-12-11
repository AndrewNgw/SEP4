package com.sep4awesomegroup.sep4app;

import com.sep4awesomegroup.sep4app.common.User;

public interface IUserDAO {
    void insert(User user);
    void getUser(final ICallBack myCallback);
}
