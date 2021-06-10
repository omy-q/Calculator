package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private Adapter adapter;

    private final View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.button_del_el){
                CharSequence str = text.getText();
                if (str.length() == 0) text.setText("");
                else text.setText(str.subSequence(0, str.length() - 1));
            }
            else if (v.getId() == R.id.button_del_all){
                text.setText("");
            }
            else {
                if (adapter.isContainEquallySign(text.getText())){
                    text.setText("");
                }
                text.append(((Button) v).getText());
                if (!adapter.isAvailable(text.getText(), false)) makeToast("Ошибка");
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
        Button equallyButton = findViewById(R.id.button_equally);
        equallyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MainActivity", String.valueOf((!adapter.isAvailable(text.getText(), true))));
                if (!adapter.isAvailable(text.getText(), true)){
                    makeToast("Ошибка");
                }
                else{
                    adapter.setData(text.getText());
                    adapter.processingData();
                    text.append("=" + adapter.getData());
                }
            }
        });
    }

    private void makeToast(String message){
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }
}