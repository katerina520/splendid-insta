package com.example.splendidavocado.splendid_insta;

import android.app.Application;

import com.parse.Parse;

public class ParseApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        final Parse.Configuration configuration = new Parse.Configuration.Builder(this)
                .applicationId("whatever")
                .clientKey("plzwork")
                .server("http://splendid-insta.herokuapp.com/parse")
                .build();
        Parse.initialize(configuration);
    }
}
