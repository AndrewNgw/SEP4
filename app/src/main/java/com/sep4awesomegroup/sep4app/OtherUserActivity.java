package com.sep4awesomegroup.sep4app;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sep4awesomegroup.sep4app.common.User;

public class OtherUserActivity extends AppCompatActivity {

    private TextView name;
    private TextView email;
    private TextView gender;
    private TextView age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_user);

        name = findViewById(R.id.nameTextView);
        email = findViewById(R.id.emailTextView);
        gender = findViewById(R.id.genderTextView);
        age = findViewById(R.id.ageTextView);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        setUserProfile(id);
    }

    public void setUserProfile(String userId){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("users").child(userId);

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User currentUser = dataSnapshot.getValue(User.class);
                if (currentUser != null){
                    name.setText(currentUser.getName());
                    email.setText(currentUser.getEmail());
                    age.setText(currentUser.getAge());
                    gender.setText(currentUser.getGender());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void closeOtherUserActivity(View view){
        finish();
    }

    public void writeEmail(View view){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse(email.getText().toString()));
        intent.putExtra(Intent.EXTRA_SUBJECT,"");
        intent.putExtra(Intent.EXTRA_TEXT, "");

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }
}
