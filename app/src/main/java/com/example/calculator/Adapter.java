package com.example.calculator;

import android.util.Log;

import java.util.ArrayList;

public class Adapter {

    private String data;

    private final ArrayList<Float> arrayNumbers = new ArrayList<>();
    private final ArrayList<Character> arrayOperations = new ArrayList<>();

    private ArrayList<Float> getNumbersArray(){
        return arrayNumbers;
    }

    private ArrayList<Character> getOperationArray(){
        return arrayOperations;
    }

    protected void processingData(){
        String number = "";
        for (int i = 0; i < data.length(); i++){
            if (Character.isDigit(data.charAt(i)) || data.charAt(i) == '.'){
                number += data.charAt(i);
            }
            else{
                arrayOperations.add(data.charAt(i));
                arrayNumbers.add(Float.parseFloat(number));
                number = "";
            }
        }
        arrayNumbers.add(Float.parseFloat(number));

        Log.i("Adapter", arrayNumbers.toString());
        Log.i("Adapter", arrayOperations.toString());
    }

    protected void setData(CharSequence data) {
        this.data = data.toString();
    }

}
