package com.sep4awesomegroup.sep4app;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity implements OnListItemClickListener {

    private RecyclerView recyclerView;
    private ViewModel vm;
    private PostsAdapter adapter;
    private TextView searchField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        searchField = findViewById(R.id.searchField);
        vm = ViewModelProviders.of(this).get(ViewModel.class);

        adapter = new PostsAdapter(this);
        vm.updateAdapter(adapter, "ocd");
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setReverseLayout(true);
        manager.setStackFromEnd(true);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    public void createPost(View view){
        Intent intent = new Intent(this, PostActivity.class);
        startActivity(intent);
    }

    @Override
    public void onListItemClick(String authorId) {
        Intent intent = new Intent(this, OtherUserActivity.class);
        intent.putExtra("id", authorId);
        startActivity(intent);
    }

    public void search(View view){
        vm.updateAdapter(adapter, searchField.getText().toString());
        adapter.notifyDataSetChanged();
    }
}
