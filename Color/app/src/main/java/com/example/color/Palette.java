package com.example.color;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TextView;

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

        //Show the context menu when i pressed for a time in on the component
        registerForContextMenu(vFilter);
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

    //##################################
    //OPTIONS MENU
    //##################################
    //Show the options menu on the device.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options, menu);//R allows us invoke the options menu with its id´s
        return super.onCreateOptionsMenu(menu);
    }

    //item actions.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {//brother methods

        TextView color = null;
        color = findViewById(R.id.color);

        switch (item.getItemId()){

            case R.id.icHelp:
                Intent intent2 = new Intent(this, HelpActivity.class);
                startActivity(intent2);
                break;
            case R.id.icTransparent:
                vAlpha.setProgress(0);

                color.setText("transparent");


                break;
            case R.id.iteTransparent:
                vAlpha.setProgress(0);
                color.setText("Trasparent");
                break;
            case R.id.iteSemitransparent:
                vAlpha.setProgress(128);
                color.setText("Semi trasnparent");
                break;
            case R.id.iteReset:
                vRed.setProgress(0);
                vGreen.setProgress(0);
                vBlue.setProgress(0);
                vAlpha.setProgress(0);
                color.setText("");
                break;
            case R.id.iteRed:
                vRed.setProgress(255);
                vGreen.setProgress(0);
                vBlue.setProgress(0);
                vAlpha.setProgress(128);
                color.setText("Red");
                break;
            case R.id.iteBlue:
                vRed.setProgress(0);
                vGreen.setProgress(0);
                vBlue.setProgress(255);
                vAlpha.setProgress(128);
                color.setText("Blue");
                break;
            case R.id.iteGreen:
                vRed.setProgress(0);
                vGreen.setProgress(255);
                vBlue.setProgress(0);
                vAlpha.setProgress(128);
                color.setText("Green");
                break;
            case R.id.iteCyan:
                vRed.setProgress(0);
                vGreen.setProgress(160);
                vBlue.setProgress(227);
                vAlpha.setProgress(128);
                color.setText("Cyan");
                break;
            case R.id.iteMagenta:
                vRed.setProgress(229);
                vGreen.setProgress(9);
                vBlue.setProgress(127);
                vAlpha.setProgress(128);
                color.setText("Magenta");
                break;
            case R.id.iteYellow:
                vRed.setProgress(236);
                vGreen.setProgress(255);
                vBlue.setProgress(0);
                vAlpha.setProgress(128);
               color.setText("Yellow");
                break;
            case R.id.iteBlack:
                vRed.setProgress(0);
                vGreen.setProgress(0);
                vBlue.setProgress(0);
                vAlpha.setProgress(128);
                color.setText("Black");
                break;
            case R.id.iteWhite:
                vRed.setProgress(255);
                vGreen.setProgress(255);
                vBlue.setProgress(255);
                vAlpha.setProgress(128);
                color.setText("White");
                break;
            case R.id.iteOpaque:
                vAlpha.setProgress(255);
                color.setText("Opaque");
                break;
            case R.id.iteAboutof:
                Intent intent = new Intent(this, AboutofActivity.class);
                startActivity(intent);
                break;
            case R.id.iteCloseApp:
                finish();
                System.exit(0);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    //##################################
    //CONTEXT MENU
    //##################################
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2, menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.iteHelp:
                Intent intent = new Intent(this, HelpActivity.class);
                startActivity(intent);
                break;
            case R.id.iteReset:
                vRed.setProgress(0);
                vGreen.setProgress(0);
                vBlue.setProgress(0);
                vAlpha.setProgress(0);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
