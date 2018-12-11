package com.sep4awesomegroup.sep4app;

import android.support.annotation.NonNull;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.Nullable;
import com.sep4awesomegroup.sep4app.utility.Post;

public class PostDAO implements IPostDAO{
    private FirebaseDatabase myFirebaseDatabase;
    private DatabaseReference usersDtabaseReference;
    private ChildEventListener childEventListener;

    public PostDAO() {
        myFirebaseDatabase = FirebaseDatabase.getInstance();
    }

    public void insert(Post post, String category){
        myFirebaseDatabase.getReference().child("posts").child(category).push().setValue(post);
    }

    public void updateAdapter(final PostsAdapter adapter, String category){
        usersDtabaseReference = myFirebaseDatabase.getReference().child("posts").child(category);

        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Post post = dataSnapshot.getValue(Post.class);
                adapter.addPost(post);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };

        usersDtabaseReference.addChildEventListener(childEventListener);
    }


}
