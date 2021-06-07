package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private Button equallyButton;
    private Adapter adapter;

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
        init();
        adapter = new Adapter();
    }



    private void init(){
        initTextView();
        initNumbersButton();
        initMathButton();
        initSpecialButton();
        initEqually();
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

    private void initEqually(){
        equallyButton = findViewById(R.id.button_equally);
        equallyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.setData(text.getText());
                adapter.processingData();
            }
        });
    }

}