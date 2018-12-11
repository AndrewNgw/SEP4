package com.sep4awesomegroup.sep4app;

import android.os.AsyncTask;

import com.sep4awesomegroup.sep4app.utility.Post;
import com.sep4awesomegroup.sep4app.utility.User;

public class Model {

    private UserDAO userDAO;
    private PostDAO postDAO;

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

    public void updateAdapter(PostsAdapter adapter, String category){
        postDAO.updateAdapter(adapter, category);
    }
}
