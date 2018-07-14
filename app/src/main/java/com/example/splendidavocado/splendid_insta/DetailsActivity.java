package com.example.splendidavocado.splendid_insta;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
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
    public TextView tvUser;

    Post.Query query = new Post.Query();

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        toolbar.setSubtitle("");


        ivImage = findViewById(R.id.ivImage);
        tvDetails= findViewById(R.id.tvDetails);
        tvTimestamp = findViewById(R.id.tvTimestamp);
        tvUser= findViewById(R.id.tvUser);

        context = getApplicationContext();

        post = (Post) Parcels.unwrap(getIntent().getParcelableExtra(Post.class.getSimpleName()));

        Glide.with(context).load(post.getImage().getUrl())
                .into(ivImage);

        tvDetails.setText(post.getDescription());
        tvUser.setText(post.getUser().getUsername().toString());

        tvTimestamp.setText(post.getCreatedAt().toString());

    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.miHome:

                Intent intent = new Intent(DetailsActivity.this, TimelineActivity.class);
                startActivity(intent);

                return true;


            case R.id.miUser:

                Intent intent2 = new Intent(DetailsActivity.this, UserActivity.class);
                startActivity(intent2);

                return true;

            case R.id.miCreate:

                Intent intent3 = new Intent(DetailsActivity.this, HomeActivity.class);
                startActivity(intent3);

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

}