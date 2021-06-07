package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text;

    private final View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.button_del_el){
                CharSequence str = text.getText();
                text.setText(str.subSequence(0, str.length() - 1));
            }
            else if (v.getId() == R.id.button_del_all){
                text.setText("");
            }
            else {
                text.append(((Button) v).getText());
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextView();
        initNumbersButton();
        initMathButton();
        initSpecialButton();
        
    }

    private void initMathButton() {

        findViewById(R.id.button_plus).setOnClickListener(listener);
        findViewById(R.id.button_minus).setOnClickListener(listener);
        findViewById(R.id.button_multiply).setOnClickListener(listener);
        findViewById(R.id.button_split).setOnClickListener(listener);
        findViewById(R.id.button_point).setOnClickListener(listener);
    }

    private  void initNumbersButton(){

        findViewById(R.id.button_0).setOnClickListener(listener);
        findViewById(R.id.button_1).setOnClickListener(listener);
        findViewById(R.id.button_2).setOnClickListener(listener);
        findViewById(R.id.button_3).setOnClickListener(listener);
        findViewById(R.id.button_4).setOnClickListener(listener);
        findViewById(R.id.button_5).setOnClickListener(listener);
        findViewById(R.id.button_6).setOnClickListener(listener);
        findViewById(R.id.button_7).setOnClickListener(listener);
        findViewById(R.id.button_8).setOnClickListener(listener);
        findViewById(R.id.button_9).setOnClickListener(listener);

    }

    private void initSpecialButton() {

        findViewById(R.id.button_del_el).setOnClickListener(listener);
        findViewById(R.id.button_del_all).setOnClickListener(listener);
    }

    private void initTextView() {
        text = findViewById(R.id.text_view);
    }

}