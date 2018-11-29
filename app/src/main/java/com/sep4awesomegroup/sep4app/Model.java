package com.sep4awesomegroup.sep4app;

import com.sep4awesomegroup.sep4app.utility.Post;
import com.sep4awesomegroup.sep4app.utility.User;

public class Model {

    private UserDAO userDAO;
    private PostDAO postDAO;

    public Model(){
         userDAO = new UserDAO();
    }

    public void addUser(User user){
        userDAO.insert(user);
    }

    public void addPost(Post post, String category){
        postDAO.insert(post, category);
    }
}
