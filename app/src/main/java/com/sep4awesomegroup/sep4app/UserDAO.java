package com.sep4awesomegroup.sep4app;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sep4awesomegroup.sep4app.utility.User;

public class UserDAO implements IUserDAO{
    private FirebaseDatabase myFirebaseDatabase;
    private DatabaseReference usersDtabaseReference;
    private DatabaseReference ref;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private User user;

    public UserDAO(){
        myFirebaseDatabase = FirebaseDatabase.getInstance();
        usersDtabaseReference = myFirebaseDatabase.getReference().child("users");
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        ref = usersDtabaseReference.child(firebaseUser.getUid());

    }

    public void insert(User user) {
        usersDtabaseReference.child(firebaseUser.getUid()).setValue(user);
    }

    public void getUser(final ICallBack myCallback){
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                user = dataSnapshot.getValue(User.class);
                myCallback.setUserProfile(user);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
