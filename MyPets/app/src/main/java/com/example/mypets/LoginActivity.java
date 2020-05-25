package com.example.mypets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void btn_login(View view){
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }

    public void btn_go_register(View view){
        Intent intent = new Intent(this, RegisterUserActivity.class);
        startActivity(intent);
    }
}
