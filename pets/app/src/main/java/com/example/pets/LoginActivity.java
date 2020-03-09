package com.example.pets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void btn_Loggin(View view){
        Toast.makeText(this, "you are loggin in", Toast.LENGTH_LONG).show();

        Intent intent = new Intent( this,
                    inbox_activity.class);
        startActivity(intent);
    }




    public void btn_sign_up(View view){
        Toast.makeText(this, "Go to register page", Toast.LENGTH_LONG).show();
        Intent intent = new Intent( this,
                register.class);
        startActivity(intent);
    }
}
