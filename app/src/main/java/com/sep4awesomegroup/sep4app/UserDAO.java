package com.sep4awesomegroup.sep4app;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sep4awesomegroup.sep4app.utility.User;

public class UserDAO {
    private FirebaseDatabase myFirebaseDatabase;
    private DatabaseReference usersDtabaseReference;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

    public UserDAO(){
        myFirebaseDatabase = FirebaseDatabase.getInstance();
        usersDtabaseReference = myFirebaseDatabase.getReference().child("users");
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
    }

    public void insert(User user) {
        usersDtabaseReference.child(firebaseUser.getUid()).setValue(user);
    }
}
