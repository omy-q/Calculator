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
        public void onClick(View v) {}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_selection);

        initImagePurpleButton();
        initImageBlueButton();
        initImageGreenButton();
        initImageDarkButton();
        initBackButton();
    }

    private void initImagePurpleButton() {

        findViewById(R.id.image_purple).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MainActivity", "PurpleTheme");
                themeValue = "PurpleTheme";
            }
        });
    }

    private void initImageDarkButton() {
        findViewById(R.id.image_dark).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MainActivity", "DarkTheme");
                themeValue = "DarkTheme";
            }
        });
    }

    private void initImageGreenButton() {
        findViewById(R.id.image_green).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MainActivity", "GreenTheme");
                themeValue = "GreenTheme";
            }
        });
    }

    private void initImageBlueButton() {
        findViewById(R.id.image_green).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MainActivity", "BlueTheme");
                themeValue = "BlueTheme";
            }
        });
    }

    private void initBackButton() {

        findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent infoThemeIntent = new Intent(ActivityThemeSelection.this, MainActivity.class);
                infoThemeIntent.putExtra(themeName, themeValue);
                setResult(RESULT_OK, infoThemeIntent);
                finish();
            }
        });
    }
}