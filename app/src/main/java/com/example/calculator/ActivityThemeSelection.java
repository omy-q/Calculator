package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ActivityThemeSelection extends AppCompatActivity {

    private final String themeName = "THEME_NAME";
    private String themeValue;
    private final View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setThemeValue(v.getId());
            finishedActivity();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_selection);

        initImageButtons();
        initBackButton();
    }

    private void initImageButtons() {
        findViewById(R.id.image_purple).setOnClickListener(listener);
        findViewById(R.id.image_green).setOnClickListener(listener);
        findViewById(R.id.image_dark).setOnClickListener(listener);
        findViewById(R.id.image_blue).setOnClickListener(listener);
    }


    private void initBackButton() {

        findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void finishedActivity() {
        Intent infoThemeIntent = new Intent();
        infoThemeIntent.putExtra(themeName, themeValue);
        setResult(RESULT_OK, infoThemeIntent);
        finish();
    }

    private void setThemeValue(int idButton) {
        switch (idButton) {
            case R.id.image_blue:
                themeValue = "BlueTheme";
                break;
            case R.id.image_dark:
                themeValue = "DarkTheme";
                break;
            case R.id.image_green:
                themeValue = "GreenTheme";
                break;
            default:
                themeValue = "PurpleTheme";
                break;
        }
        Log.i("ActivityThemeSelection", "getIdTheme: " + themeValue);
    }
}