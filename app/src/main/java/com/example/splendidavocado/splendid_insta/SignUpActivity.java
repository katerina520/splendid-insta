package com.example.splendidavocado.splendid_insta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.text.ParseException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity {


    @BindView(R.id.etusername) EditText etusername;
    @BindView(R.id.etpassword) EditText etpassword;
    @BindView(R.id.etemail) EditText etemail;
    @BindView(R.id.createBtn) Button createBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.createBtn)
    public void CreateAccount() {
        final String username = etusername.getText().toString();
        final String password = etpassword.getText().toString();
        final String email = etemail.getText().toString();
        // Create the ParseUser
        ParseUser user = new ParseUser();
        // Set core properties
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        // Invoke signUpInBackground
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(com.parse.ParseException e) {

                if (e == null ) {
                    backToLogin();


                } else {
                    Log.e("CreateAccountActivity", "Create account failure");
                    e.printStackTrace();
                }
            }
        });


    }

    private void backToLogin() {
        Toast.makeText(this, "Sign up succcesful!", Toast.LENGTH_LONG).show();
        finish();

    }




}
