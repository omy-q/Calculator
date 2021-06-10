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
        arrayNumbers.clear();
        arrayOperations.clear();
        this.data = data.toString();
    }

    protected CharSequence getData(){
        Calculator calculator = new Calculator(getNumbersArray(), getOperationArray());
        return Float.toString(calculator.getResult());
    }

    private boolean isContainMathSign(char ch){
        return(ch == '+' || ch == '-' ||  ch == '*' || ch == '/' || ch == '.' || ch == '=');
    }

    private boolean isContainRowMathSign(char ch0, char ch1){
        return(isContainMathSign(ch0) && isContainMathSign(ch1));
    }

    private boolean isContainRowMathSignAllText(CharSequence text){
        boolean isContain = false;
        for (int i = 0; i < text.length() - 1; i++){
            if (isContainRowMathSign(text.charAt(i), text.charAt(i+1))) {
                isContain = true;
                break;
            }
        }
        return isContain;
    }

    protected boolean isContainEquallySign(CharSequence text){
        return(text.toString().contains("="));
    }

    protected boolean isAvailable(CharSequence text, boolean isClickEqually){
        if (text.length() == 0) return false;
        if (isContainMathSign(text.charAt(0))) return false;
        if (text.length() > 1){
            if (isContainRowMathSign(text.charAt(text.length() - 2), text.charAt(text.length() - 1)))
                return false;
        }
        if (isClickEqually){
            if (isContainEquallySign(text)) return false;
            if (isContainMathSign(text.charAt(text.length() - 1)) || isContainRowMathSignAllText(text)){
                return false;
            }
        }
        return  true;
    }

}
