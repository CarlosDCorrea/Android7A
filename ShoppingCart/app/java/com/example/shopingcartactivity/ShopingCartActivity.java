package com.example.shopingcartactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class ShopingCartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoping_cart);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);//R allows us invoke the options menu with its id´s
        return super.onCreateOptionsMenu(menu);
    }

    //item actions.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {//brother methods

        switch (item.getItemId()){

            case R.id.iteHelp:
                Toast.makeText(this, "You´ve pressed help option", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iteAboutOf:
                Toast.makeText(this, "You´ve pressed About of option", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iteCloseApp:
                finish();
                System.exit(0);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
