package com.example.rememberme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {

    private TextView mTvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        mTvName = findViewById(R.id.tvName);
        String data = PreferenceHelper.getStringFromPreference(HomeScreen.this, "userName");
        PreferenceHelper.writeStringToPreference(HomeScreen.this, "added", "");
        mTvName.setText(data);
    }
}