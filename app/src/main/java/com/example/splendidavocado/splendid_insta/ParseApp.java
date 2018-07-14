package com.example.splendidavocado.splendid_insta;

import android.app.Application;

import com.example.splendidavocado.splendid_insta.model.Post;
import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Post.class);

        final Parse.Configuration configuration = new Parse.Configuration.Builder(this)
                .applicationId("whatever")
                .clientKey("plzwork")
                .server("http://splendid-insta.herokuapp.com/parse")
                .build();
        Parse.initialize(configuration);
    }
}
