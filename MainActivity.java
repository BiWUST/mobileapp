package com.example.maxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView numbersTextView;
    private int[] numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numbersTextView = findViewById(R.id.numbersTextView);
    }

    public void generateNumbers(View view) {
        numbers = generateRandomNumbers(10, 1, 100);
        numbersTextView.setText(Arrays.toString(numbers));
    }

    public void sortAscending(View view) {
        if (numbers != null) {
            sortNumbersAscending(numbers);
            numbersTextView.setText(Arrays.toString(numbers));
        }
    }

    public void sortDescending(View view) {
        if (numbers != null) {
            sortNumbersDescending(numbers);
            numbersTextView.setText(Arrays.toString(numbers));
        }
    }

    private int[] generateRandomNumbers(int count, int min, int max) {
        int[] numbers = new int[count];
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            numbers[i] = random.nextInt(max - min + 1) + min;
        }

        return numbers;
    }

    private void sortNumbersAscending(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int key = numbers[i];
            int j = i - 1;

            while (j >= 0 && numbers[j] > key) {
                numbers[j + 1] = numbers[j];
                j--;
            }

            numbers[j + 1] = key;
        }
    }

    private void sortNumbersDescending(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int key = numbers[i];
            int j = i - 1;

            while (j >= 0 && numbers[j] < key) {
                numbers[j + 1] = numbers[j];
                j--;
            }

            numbers[j + 1] = key;
        }
    }
}
