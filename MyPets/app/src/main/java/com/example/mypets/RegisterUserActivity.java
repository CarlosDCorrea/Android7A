package com.example.mypets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterUserActivity extends AppCompatActivity {

    private EditText email, password, password2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        email = findViewById(R.id.txtEmailRegisterUser);
        password = findViewById(R.id.txtPasswordRegisterUser);
        password2 = findViewById(R.id.txtPasswordRegisterUserRepeat);
    }

    public void btn_go_login(View view){
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

    public void btn_register(View view){
        //connect to DB
        Database manager = new Database(this, "pets", null, 1);
        // let write in DB
        SQLiteDatabase pets = manager.getWritableDatabase();
        // Get values from UI
        String EMAIL = email.getText().toString();
        String PASSWORD = password.getText().toString();
        String PASSWORD2 = password2.getText().toString();

        if (EMAIL.isEmpty() || PASSWORD.isEmpty() || PASSWORD2.isEmpty()){
            Toast.makeText(this, "you must entry data into fields", Toast.LENGTH_SHORT).show();
            email.setError("");
            password.setError("");
            password2.setError("");
        }
        else{
            if (!PASSWORD.equals(PASSWORD2)){
                Toast.makeText(this, "Passwords are not equals", Toast.LENGTH_SHORT).show();
                password.setError("");
                password2.setError("");
            }
            else{
                //validate if user already exist
                Cursor row = pets.rawQuery("SELECT * FROM users " +
                        "WHERE email = '"+EMAIL+"'", null);
                //getCount() < 1 or moveToFirst()
                if(row.getCount() > 0){
                    Toast.makeText(this, "The Email is already registered", Toast.LENGTH_SHORT).show();
                }
                else {
                    //make package values
                    ContentValues data = new ContentValues();
                    data.put("email", EMAIL);
                    data.put("password", PASSWORD);

                    pets.insert("users", null, data);
                    pets.close();

                    Toast.makeText(this, "An user has been added", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        }


    }
}
