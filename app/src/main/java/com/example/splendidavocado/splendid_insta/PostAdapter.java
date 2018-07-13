package com.example.splendidavocado.splendid_insta;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.splendidavocado.splendid_insta.model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder>{
    private List <Post> mPosts;

    Context context;
    public PostAdapter(List<Post> posts) {
        mPosts = posts;
    }


    // Clean all elements of the recycler
    public void clear() {
        mPosts.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Post> list) {
        mPosts.addAll(list);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.item_post, parent, false);
        ViewHolder viewHolder = new ViewHolder(postView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // get the dsta according to postoon

        Post post = mPosts.get(position);


        // populate the views according to data
        holder.tvUsername.setText(post.getUser().getUsername().toString());


       // int radius = 30; // corner radius, higher value = more rounded
      //  int margin = 10; // crop margin, set to 0 for corners with no crop

        Glide.with(context).load(post.getImage().getUrl()).into(holder.ivProfileImage);

        // leaving this lines here because MyGlideApp doesn't properly work but maybe it will
        // in the future I have my hopes
        //  .transform(new RoundedCornersTransformation(radius, margin))
        //  .into(holder.ivProfileImage);

    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }





    public static class ViewHolder extends RecyclerView.ViewHolder {
        // public ImageView ivProfileImage;
        public TextView tvUsername;
        public ImageView ivProfileImage;


        public ViewHolder(View itemView) {

            super(itemView);
            // perform findViewById lookup
            ivProfileImage = (ImageView) itemView.findViewById(R.id.ivProfileImage);


            tvUsername = (TextView) itemView.findViewById(R.id.tvUserName);



          /*  tvScreenName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String userScreenName = tvScreenName.getText().toString();
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://twitter.com/"+userScreenName));
                    view.getContext().startActivity(browserIntent);


                }
            });

            reply.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {
                    Intent replyIntent = new Intent (view.getContext(), ComposeActivity.class );
                    String userScreenName = tvScreenName.getText().toString();
                    replyIntent.putExtra("userScreenName", userScreenName);
                    String tweetText = tvBody.getText().toString();
                    //  replyIntent.putExtra("tweetText", tweetText);
                    view.getContext().startActivity(replyIntent);



                }
            });

            */


        }
    }





}
