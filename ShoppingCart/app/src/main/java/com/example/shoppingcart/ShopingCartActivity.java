package com.example.shoppingcart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShopingCartActivity extends AppCompatActivity {

    private ListView products;
    private EditText name_product, quantity_product;
    private ArrayList<String> prod;
    private ArrayList<String> blank_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoping_cart);

        products = findViewById(R.id.listProducts);
        name_product = findViewById(R.id.txtProductName);
        quantity_product = findViewById(R.id.txtProductQuantity);
        prod = new ArrayList<>();

    }

    public void btn_view_all_products(View view){

        prod.add(name_product.getText().toString() + "\n" + quantity_product.getText().toString());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, prod);
        products.setAdapter(adapter);
    }

    public void btn_buy_all_products(View view){
        blank_list = new  ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, blank_list);
        products.setAdapter(adapter);
        Toast.makeText(this, "The products have been added to your account", Toast.LENGTH_SHORT).show();
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

            case R.id.iteCloseApp:
                finish();
                System.exit(0);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
