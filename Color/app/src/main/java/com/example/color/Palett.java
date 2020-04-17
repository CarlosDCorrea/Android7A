package com.example.color;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

public class Palett extends AppCompatActivity
        implements SeekBar.OnSeekBarChangeListener {

    private SeekBar vRed = null;
    private SeekBar vGreen = null;
    private SeekBar vBlue = null;
    private SeekBar vAlpha = null;
    private View vFilter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palett);

        //Get component's id's
        vRed = findViewById(R.id.sbrRed);
        vGreen = findViewById(R.id.sbrGreen);
        vBlue = findViewById(R.id.sbrBlue);
        vAlpha = findViewById(R.id.sbrAlpha);
        vFilter = findViewById(R.id.vieColors);

        vRed.setOnSeekBarChangeListener(this);
        vGreen.setOnSeekBarChangeListener(this);
        vBlue.setOnSeekBarChangeListener(this);
        vAlpha.setOnSeekBarChangeListener(this);

    }

    //Menus
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            //1. Get Seekbar values
            int r = vRed.getProgress();
            int g = vRed.getProgress();
            int b = vRed.getProgress();
            int a = vRed.getProgress();

            //2. convert values (in step 1) to ARGB function
            int filter_color Color.argb(a, r, g, b); // the variables above

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }


    //Show the options menu on the device.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options, menu);//R nos allows us invoke the options menu with its id´s
        return super.onCreateOptionsMenu(menu);
    }

    //item actions.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {//metodos hermanos
        switch (item.getItemId()){
            case R.id.iteTransparent:
                Toast.makeText(this, "This color is going to change to Transparent", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iteSemitransparent:
                Toast.makeText(this, "This color is going to change to Semi-transparent", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iteReset:
                Toast.makeText(this, "The color is going to reset", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iteRed:
                Toast.makeText(this, "This color is going to change to Red", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iteBlue:
                Toast.makeText(this, "This color is going to change to Blue", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iteGreen:
                Toast.makeText(this, "This color is going to change to Green", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iteCyan:
                Toast.makeText(this, "This color is going to change to Cyan", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iteMagenta:
                Toast.makeText(this, "This color is going to change to Magenta", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iteYellow:
                Toast.makeText(this, "This color is going to change to Yellow", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iteBlack:
                Toast.makeText(this, "This color is going to change to Black", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iteWhite:
                Toast.makeText(this, "This color is going to change to White", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iteOpaque:
                Toast.makeText(this, "This color is going to turn Opaque", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iteAboutof:
                Toast.makeText(this, "Go to the About of Page", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
