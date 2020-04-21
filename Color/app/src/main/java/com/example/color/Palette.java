package com.example.color;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

public class Palette extends AppCompatActivity
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
            int g = vGreen.getProgress();
            int b = vBlue.getProgress();
            int a = vAlpha.getProgress();

            //2. convert values (in step 1) to ARGB function
            int filter_color = Color.argb(a, r, g, b); // the variables above
            //3. set the new color to image
            vFilter.setBackgroundColor(filter_color);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
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
                vAlpha .setProgress(0);
                break;
            case R.id.iteSemitransparent:
                vAlpha.setProgress(128);
                break;
            case R.id.iteReset:
                vRed.setProgress(0);
                vGreen.setProgress(0);
                vBlue.setProgress(0);
                vAlpha.setProgress(0);
                break;
            case R.id.iteRed:
                vRed.setProgress(255);
                vGreen.setProgress(0);
                vBlue.setProgress(0);
                vAlpha.setProgress(128);
                break;
            case R.id.iteBlue:
                vRed.setProgress(0);
                vGreen.setProgress(0);
                vBlue.setProgress(255);
                vAlpha.setProgress(128);
                break;
            case R.id.iteGreen:
                vRed.setProgress(0);
                vGreen.setProgress(255);
                vBlue.setProgress(0);
                vAlpha.setProgress(128);
                break;
            case R.id.iteCyan:
                vRed.setProgress(0);
                vGreen.setProgress(160);
                vBlue.setProgress(227);
                vAlpha.setProgress(128);
                break;
            case R.id.iteMagenta:
                vRed.setProgress(229);
                vGreen.setProgress(9);
                vBlue.setProgress(127);
                vAlpha.setProgress(128);
                break;
            case R.id.iteYellow:
                vRed.setProgress(236);
                vGreen.setProgress(255);
                vBlue.setProgress(0);
                vAlpha.setProgress(128);
                break;
            case R.id.iteBlack:
                vRed.setProgress(0);
                vGreen.setProgress(0);
                vBlue.setProgress(0);
                vAlpha.setProgress(128);
                break;
            case R.id.iteWhite:
                vRed.setProgress(255);
                vGreen.setProgress(255);
                vBlue.setProgress(255);
                vAlpha.setProgress(128);
                break;
            case R.id.iteOpaque:
                vAlpha.setProgress(255);
                break;
            case R.id.iteAboutof:
                Intent intent = new Intent(this, AboutofActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
