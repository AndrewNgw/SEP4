package com.sep4awesomegroup.sep4app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class PostActivity extends AppCompatActivity {

    private Button btnUpdate;
    private EditText txtPost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        btnUpdate = (Button)findViewById(R.id.btnpost);
        txtPost = (EditText)findViewById(R.id.editText);


    }
}
