package com.example.splendidavocado.splendid_insta;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.splendidavocado.splendid_insta.model.Post;

import org.parceler.Parcels;

public class DetailsActivity extends AppCompatActivity {


    Post post;
    public ImageView ivImage;
    public TextView tvDetails;
    public TextView tvTimestamp;

    Post.Query query = new Post.Query();

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        ivImage = findViewById(R.id.ivImage);
        tvDetails= findViewById(R.id.tvDetails);
        tvTimestamp = findViewById(R.id.tvTimestamp);

        context = getApplicationContext();

        post = (Post) Parcels.unwrap(getIntent().getParcelableExtra(Post.class.getSimpleName()));

        Glide.with(context).load(post.getImage().getUrl())
                .into(ivImage);

        tvDetails.setText(post.getDescription());

        tvTimestamp.setText(post.getCreatedAt().toString());

    }
}