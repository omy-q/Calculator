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

    protected Float getResult() {
        calculate();
        return numbers.get(0);
    }

    private void calculate() {
        int count = operations.size();
        for (int i = 0; i < count; i++) {
            Log.i("Calculator Index", Integer.toString(i));
            if (operations.get(i) == '*'|| operations.get(i) == '/') {
                numbers.set(i, toCalculate(numbers.get(i), numbers.get(i + 1), operations.get(i)));
                operations.remove(i);
                numbers.remove(i + 1);
                count--;
            }
            Log.i("Calculator", this.numbers.toString());
            Log.i("Calculator", this.operations.toString());

        }

        for (int i = 0; i < count; i++) {
            Log.i("Calculator Index", Integer.toString(i));
            if (operations.get(i) == '+'|| operations.get(i) == '-') {
                numbers.set(i, toCalculate(numbers.get(i), numbers.get(i + 1), operations.get(i)));
                operations.remove(i);
                numbers.remove(i + 1);
                count--;
            }
            Log.i("Calculator", this.numbers.toString());
            Log.i("Calculator", this.operations.toString());

        }
    }

    private Float toCalculate(Float num1, Float num2, char operator) {
        Float result;
        switch (operator){
            case '*':
                result = toMultiply(num1, num2);
                break;
            case '/':
                result = toSplit(num1, num2);
                break;
            case '+':
                result = toAdd(num1, num2);
                break;
            case '-':
                result = toSubtract(num1, num2);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
        return result;
    }

    private Float toAdd(Float num1, Float num2) {
        return (num1 + num2);
    }

    private Float toSubtract(Float num1, Float num2) {
        return (num1 - num2);
    }

    private Float toMultiply(Float num1, Float num2) {
        return (num1 * num2);
    }

    private Float toSplit(Float num1, Float num2) {
        return (num1 / num2);
    }
}
