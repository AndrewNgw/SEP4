package com.sep4awesomegroup.sep4app;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.sep4awesomegroup.sep4app.common.Post;
import com.sep4awesomegroup.sep4app.common.User;

public class ViewModel extends AndroidViewModel implements IViewModel{

    private Model model;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

    public ViewModel(@NonNull Application application){
        super(application);
        model = new Model();
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

    public void getUser(ICallBack myCallback){
        model.getUser(myCallback);
    }

    public void updateAdapter(PostsAdapter adapter, String category){
        model.updateAdapter(adapter, category);
    }
}
