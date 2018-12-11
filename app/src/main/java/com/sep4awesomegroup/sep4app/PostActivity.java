package com.sep4awesomegroup.sep4app;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PostActivity extends AppCompatActivity {

    private Button btnUpdate;
    private EditText txtPost;
    private String post;
    private IViewModel vm;
    private EditText category;
    private SimpleDateFormat dateFormater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        vm = ViewModelProviders.of(this).get(ViewModel.class);
        dateFormater = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());


        btnUpdate = findViewById(R.id.btn_post);
        txtPost = findViewById(R.id.editText);
        category = findViewById(R.id.categoryText);
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

        if(post == null)
        {
            Toast.makeText(this,"Please write something to post",Toast.LENGTH_SHORT);
        }
        else 
        {
            String date = dateFormater.format(new Date());
            vm.addPost(post, date, category.getText().toString());
            finish();
        }
    }

}
