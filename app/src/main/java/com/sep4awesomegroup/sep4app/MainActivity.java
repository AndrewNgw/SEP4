package com.sep4awesomegroup.sep4app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.annotations.Nullable;
import com.sep4awesomegroup.sep4app.utility.Post;
import com.sep4awesomegroup.sep4app.utility.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authlistener;
    private static final int RC_SIGN_IN = 1;
    private RecyclerView recyclerView;
    private PostsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Post> list = new ArrayList<>();
        list.add(new Post("afafa", "helloo there how are you?", "10.10.2018"));
        list.add(new Post("aaafa", " I dont caaare and I love it!", "10.10.2018"));
        adapter = new PostsAdapter(list);
        recyclerView.setAdapter(adapter);
        firebaseAuth = FirebaseAuth.getInstance();
        authlistener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {

                }
                else{
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder().setIsSmartLockEnabled(false)
                                    .setAvailableProviders(Arrays.asList(
                                            new AuthUI.IdpConfig.EmailBuilder().build()))
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };

        ViewModel vm = ViewModelProviders.of(this).get(ViewModel.class);
        //vm.addUser(new User("Alex", "hello@google.com", "male", 21));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Welcome!", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_CANCELED) {
                finish();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        firebaseAuth.addAuthStateListener(authlistener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        firebaseAuth.removeAuthStateListener(authlistener);
    }
}
