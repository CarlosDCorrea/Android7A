package com.example.mypets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    private EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.EmailUserLogin);
        password = findViewById(R.id.PasswordUserLogin);

    }

    public void btn_login(View view){


        String EMAIL = email.getText().toString();
        String PASSWORD = password.getText().toString();

        if (EMAIL.isEmpty() || PASSWORD.isEmpty()){
            Toast.makeText(this, "you must entry data into fields", Toast.LENGTH_SHORT).show();
            email.setError("");
            password.setError("");
        }
        else{
            //connect to DB
            Database manager = new Database(this, "pets", null, 1);
            // let write in DB
            SQLiteDatabase pets = manager.getReadableDatabase();
            //validate if user already exist
            Cursor row = pets.rawQuery("SELECT * FROM users " +
                    "WHERE email = ? and password = ? LIMIT 1", new String[]{EMAIL, PASSWORD});
            //getCount() < 1 or moveToFirst()
            if(row.getCount() > 0){
                Intent i = new Intent(this, ListPets.class);
                startActivity(i);
            }
            else {
                Toast.makeText(this, "Invalid information", Toast.LENGTH_SHORT).show();
                email.setError("");
                password.setError("");
            }

        }

    }

    public void btn_go_register(View view){
        Intent intent = new Intent(this, RegisterUserActivity.class);
        startActivity(intent);
    }
}
