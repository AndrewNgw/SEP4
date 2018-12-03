package com.sep4awesomegroup.sep4app;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.sep4awesomegroup.sep4app.utility.Post;

public class PostActivity extends AppCompatActivity {

    private Button btnUpdate;
    private EditText txtPost;
    private String post;
    private ViewModel vm;

    // Create a storage reference from our app

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        vm = ViewModelProviders.of(this).get(ViewModel.class);


        btnUpdate = (Button)findViewById(R.id.btnpost);
        txtPost = (EditText)findViewById(R.id.editText);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validatePostInfor();
            }
        });
    }

    private void validatePostInfor()
    {
        post = txtPost.getText().toString();

        //validation
        if(post == null)
        {
            Toast.makeText(this,"Please write something to post",Toast.LENGTH_SHORT);
        }
        else 
        {
            storingTextToStorage();
        }
    }

    private void storingTextToStorage()
    {

        vm.addPost(new Post("blabla","Slum","03/12/2018"),"sugar free");
    }

}
