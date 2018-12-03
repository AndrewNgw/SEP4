package com.sep4awesomegroup.sep4app;

import android.os.AsyncTask;
import android.util.Log;

import com.sep4awesomegroup.sep4app.utility.Post;
import com.sep4awesomegroup.sep4app.utility.User;

public class Model {

    private UserDAO userDAO;
    private PostDAO postDAO;

    public Model(PostsAdapter adapter){
         userDAO = new UserDAO();
         postDAO = new PostDAO(adapter);
    }

    public void addUser(User user){
        //userDAO.insert(user);
        new AddUserAsynkTask(userDAO).execute(user);
    }

    public void addPost(Post post, String category){
        postDAO.insert(post, category);
    }

    public User getUser(){
        return userDAO.getUser();
    }

    private static class AddUserAsynkTask extends AsyncTask<User, Void, Void> {
        private UserDAO userDAO;

        private AddUserAsynkTask(UserDAO userDAO){
            this.userDAO = userDAO;
        }

        @Override
        protected Void doInBackground(User... hairSalons) {
            userDAO.insert(hairSalons[0]);
            return null;
        }
    }
}
