package com.sep4awesomegroup.sep4app;

import com.sep4awesomegroup.sep4app.utility.User;

public class Model {

    private  UserDAO userDAO;

    public Model(){
         userDAO = new UserDAO();
    }

    public void addUser(User user){
        userDAO.insert(user);
    }
}
