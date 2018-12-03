package com.sep4awesomegroup.sep4app;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.sep4awesomegroup.sep4app.utility.Post;
import com.sep4awesomegroup.sep4app.utility.User;

public class ViewModel extends AndroidViewModel {

    private Model model;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private PostsAdapter adapter;

    public ViewModel(@NonNull Application application){
        super(application);
        adapter = new PostsAdapter();
        model = new Model(adapter);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
    }

    public void addUser(User user){
        model.addUser(user);
    }

    public void addPost(String content, String date, String category){
        Post post = new Post(firebaseUser.getUid(), content, date);
        model.addPost(post, category);
    }

    public PostsAdapter getAdapter(){
        return adapter;
    }

    public User getUser(){
        return  model.getUser();
    }
}
