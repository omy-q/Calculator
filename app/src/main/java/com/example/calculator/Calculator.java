package com.example.calculator;

import android.util.Log;

import java.util.ArrayList;

public class Calculator {

    private final ArrayList<Float> numbers;
    private final ArrayList<Character> operations;

    protected Calculator(ArrayList<Float> numbers, ArrayList<Character> operations){
        this.numbers = numbers;
        this.operations = operations;
        Log.i("Calculator", this.numbers.toString());
        Log.i("Calculator", this.operations.toString());
    }

    protected Float getResult() {
        calculate();
        return numbers.get(0);
    }

    protected void calculate(){
        int count = operations.size();
        for(int i = 0; i < count; i++) {
            Log.i("Calculator Index", Integer.toString(i));
            if (operations.get(i) == '*') {
                numbers.set(i, toMultiply(numbers.get(i), numbers.get(i + 1)));
                operations.remove(i);
                numbers.remove(i + 1);
                count--;
            }
            Log.i("Calculator", this.numbers.toString());
            Log.i("Calculator", this.operations.toString());

        }

        for(int i = 0; i < count; i++){
            Log.i("Calculator Index", Integer.toString(i));
            if (operations.get(i) == '/'){
                numbers.set(i, toSplit(numbers.get(i), numbers.get(i+1)));
                operations.remove(i);
                numbers.remove(i+1);
                count--;
            }
            Log.i("Calculator", this.numbers.toString());
            Log.i("Calculator", this.operations.toString());
        }

        for(int i = 0; i < count; i++) {
            Log.i("Calculator Index", Integer.toString(i));
            if (operations.get(i) == '+') {
                numbers.set(i, toAdd(numbers.get(i), numbers.get(i + 1)));
                operations.remove(i);
                numbers.remove(i + 1);
                count--;
            }
            Log.i("Calculator", this.numbers.toString());
            Log.i("Calculator", this.operations.toString());

        }
        for(int i = 0; i < count; i++){
            Log.i("Calculator Index", Integer.toString(i));
            if (operations.get(i) == '-'){
                numbers.set(i, toSubtract(numbers.get(i), numbers.get(i+1)));
                operations.remove(i);
                numbers.remove(i+1);
                count--;
            }
            Log.i("Calculator", this.numbers.toString());
            Log.i("Calculator", this.operations.toString());
        }
    }


    private Float toAdd(Float num1, Float num2){
        return (num1 + num2); }

    private Float toSubtract(Float num1, Float num2){
        return (num1 - num2); }

    private Float toMultiply(Float num1, Float num2){
        return (num1 * num2); }

    private Float toSplit(Float num1, Float num2){
        return (num1 / num2); }
}
