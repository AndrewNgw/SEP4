package com.sep4awesomegroup.sep4app;

import android.os.AsyncTask;

import com.sep4awesomegroup.sep4app.common.Post;
import com.sep4awesomegroup.sep4app.common.User;

public class Model implements IModel{

    private IUserDAO userDAO;
    private IPostDAO postDAO;

    public Model(){
         userDAO = new UserDAO();
         postDAO = new PostDAO();
    }

    public void addUser(User user){
        new AddUserAsynkTask(userDAO).execute(user);
    }

    public void addPost(Post post, String category){
        postDAO.insert(post, category);
    }

    public void getUser(ICallBack myCallback){
        userDAO.getUser(myCallback);
    }

    private static class AddUserAsynkTask extends AsyncTask<User, Void, Void> {
        private IUserDAO userDAO;

        private AddUserAsynkTask(IUserDAO userDAO){
            this.userDAO = userDAO;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDAO.insert(users[0]);
            return null;
        }
    }

    public void updateAdapter(PostsAdapter adapter, String category){
        postDAO.updateAdapter(adapter, category);
    }
}
