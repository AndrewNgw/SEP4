package com.sep4awesomegroup.sep4app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ArrayAdapter;

import android.widget.ImageView;
import android.widget.Spinner;



import com.google.firebase.auth.FirebaseAuth;


public class ProfileActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authlistener;
    private static final int RC_SIGN_IN = 1;

    // define spinner
    Spinner sp;

    ImageView imageView;

    //define array adapter of string type
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_profile);

        //
        sp = (Spinner) findViewById(R.id.spinner);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.gender));


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // set adapter to spinner
        sp.setAdapter(adapter);

        // Button camera


    }


}
