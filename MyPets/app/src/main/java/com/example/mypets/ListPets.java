package com.example.mypets;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListPets extends AppCompatActivity {

    private ListView listAllPets;
    ArrayList<String> listItems;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pets);

        listAllPets = findViewById(R.id.AllPets);

        listItems = new ArrayList<>();

        //here we going to list all pets
        viewAllPets();
    }

    private void viewAllPets() {

        //connect to DB
        Database control = new Database(this, "pets", null, 1);

        // let write in DB
        SQLiteDatabase pets = control.getWritableDatabase();
        /*Cursor row1 = pets.rawQuery("SELECT * FROM pets", null);

        if (row1.getCount() == 0) {
            Toast.makeText(this, "There is not data to show", Toast.LENGTH_SHORT).show();
        }else{
            while(row.moveToNext()){
                listItems.add(row.getString(1));
            }
            adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, listItems);
            listAllPets.setAdapter(adapter);
        }*/

    }
}

