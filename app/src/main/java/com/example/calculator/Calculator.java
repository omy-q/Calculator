package com.example.calculator;

import android.util.Log;

import java.util.ArrayList;

public class Calculator {

    private final ArrayList<Float> numbers;
    private final ArrayList<Character> operations;

    protected Calculator(ArrayList<Float> numbers, ArrayList<Character> operations) {
        this.numbers = numbers;
        this.operations = operations;
        Log.i("Calculator", this.numbers.toString());
        Log.i("Calculator", this.operations.toString());
    }

}