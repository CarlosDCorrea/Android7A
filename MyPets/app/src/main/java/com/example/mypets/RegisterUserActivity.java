package com.example.mypets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterUserActivity extends AppCompatActivity {

    private EditText email, password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        email = findViewById(R.id.txtEmail);
        password = findViewById(R.id.txtPassword);
    }

    public void btn_register(View view){
        Database manager = new Database(this, "pets", null, 1);
        SQLiteDatabase pets = manager.getWritableDatabase();

        String EMAIL = email.getText().toString();
        String PASSWORD = password.getText().toString();

        ContentValues data = new ContentValues();
        data.put("email", EMAIL);
        data.put("password", PASSWORD);

        pets.insert("users", null, data);
        pets.close();

        Toast.makeText(this, "An user has been added", Toast.LENGTH_SHORT).show();
    }
}
