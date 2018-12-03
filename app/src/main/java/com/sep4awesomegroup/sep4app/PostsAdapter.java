package com.sep4awesomegroup.sep4app;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sep4awesomegroup.sep4app.utility.Post;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostHolder> {

    private List<Post> posts;

    public PostsAdapter(List<Post> posts){
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.post_item_layout, viewGroup, false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder postHolder, int i) {
        Post currentPost = posts.get(i);
        postHolder.date.setText(currentPost.getDate());
        postHolder.content.setText(currentPost.getContent());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class PostHolder extends RecyclerView.ViewHolder {

        TextView date;
        TextView content;

        public PostHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.dateText);
            content = itemView.findViewById(R.id.contentText);
        }
    }

    public void addPost(Post post){
        posts.add(post);
    }

    public void removePost(Post post){
        for (int i = 0; i < posts.size(); i++) {
            if(posts.get(i).equals(post)){
                posts.remove(i);
            }
        }
    }
}
