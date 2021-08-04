package com.example.taskify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {
    private Button mBtnCreateAnAccount;
    private EditText mEtEmail;
    private EditText mEtPassword;
    private EditText mEtRePassword;

    private String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initViews();
        mBtnCreateAnAccount.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                boolean isPasswordValid = isPasswordValid();
                boolean isEmailValid = isEmailValid();
                boolean isRePasswordValid = isRePasswordValid();
                if (isEmailValid && isPasswordValid && isRePasswordValid) {
                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    private void initViews() {
        mEtEmail = findViewById(R.id.etEmail);
        mEtPassword = findViewById(R.id.etPassword);
        mEtRePassword = findViewById(R.id.etRePassword);
        mBtnCreateAnAccount = findViewById(R.id.btnCreateAccount);
    }

    private boolean isEmailValid() {
        if (mEtEmail.getText().toString().matches(emailValidation)) {
            return true;
        } else {
            mEtEmail.setError("Invalid email");
            return false;
        }
    }

    private boolean isPasswordValid() {
        if (mEtPassword.getText().toString().length() >= 6) {
            return true;
        } else {
            mEtPassword.setError("Use 6 characters or more for your password");
            return false;
        }
    }

    private boolean isRePasswordValid() {
        if (mEtRePassword.getText().toString().equals(mEtPassword.getText().toString()) ) {
            return true;
        } else {
            mEtRePassword.setError("Those passwords didn’t match. Try again.");
            return false;
        }
    }
}