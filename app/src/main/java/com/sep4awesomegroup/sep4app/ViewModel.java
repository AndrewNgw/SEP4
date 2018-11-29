package com.sep4awesomegroup.sep4app;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.sep4awesomegroup.sep4app.utility.Post;
import com.sep4awesomegroup.sep4app.utility.User;

public class ViewModel extends AndroidViewModel {

    private Model model;

    public ViewModel(@NonNull Application application){
        super(application);
        model = new Model();
    }

    public void addUser(User user){
        model.addUser(user);
    }

    public void addPost(Post post, String category){
        model.addPost(post, category);
    }
}
//asqhwdiqwhjadij
