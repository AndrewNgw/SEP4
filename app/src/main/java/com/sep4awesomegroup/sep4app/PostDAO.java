package com.sep4awesomegroup.sep4app;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sep4awesomegroup.sep4app.utility.Post;

public class PostDAO implements IPostDAO{
    private FirebaseDatabase myFirebaseDatabase;
    private DatabaseReference usersDtabaseReference;

    public PostDAO() {
        myFirebaseDatabase = FirebaseDatabase.getInstance();
        usersDtabaseReference = myFirebaseDatabase.getReference().child("posts");
    }

    public void insert(Post post, String category){
        usersDtabaseReference.child(category).setValue(post);
    }
}
