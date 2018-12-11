package com.sep4awesomegroup.sep4app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.arch.lifecycle.ViewModelProviders;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.sep4awesomegroup.sep4app.common.User;

public class ProfileActivity extends AppCompatActivity implements ICallBack{

    private Spinner sp;
    private ArrayAdapter<String> adapter;
    private TextView name;
    private TextView email;
    private TextView age;
    private IViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_profile);

        vm = ViewModelProviders.of(this).get(ViewModel.class);

        name = findViewById(R.id.nameText);
        email = findViewById(R.id.emailText);
        age = findViewById(R.id.ageText);

        //
        sp = (Spinner) findViewById(R.id.spinner);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.gender));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // set adapter to spinner
        sp.setAdapter(adapter);

        vm.getUser(this);
    }

    public void updateProfile(View v){
        vm.addUser(new User(name.getText().toString(), email.getText().toString(), sp.getSelectedItem().toString(), age.getText().toString()));
        closeActivity(v);
    }

    public void closeActivity(View v){
        finish();
    }

    @Override
    public void setUserProfile(User user){
        if (user != null){
            name.setText(user.getName());
            email.setText(user.getEmail());
            age.setText(user.getAge());
        }
    }
}
