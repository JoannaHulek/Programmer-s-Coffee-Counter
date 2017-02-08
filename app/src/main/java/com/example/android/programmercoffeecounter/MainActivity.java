package com.example.android.programmercoffeecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.R.attr.inAnimation;
import static android.R.attr.lines;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int coffeePoints = 0;
    private int linesOfCode = 0;
    private int efficiency = 0;

    public void addCoffeePoints(View v) {

        String tag = v.getTag().toString();
        int points = Integer.parseInt(tag);

        coffeePoints += points;

        display();

    }

    public void addLinesOfCode(View v) {

        String tag = v.getTag().toString();
        int lines = Integer.parseInt(tag);

        linesOfCode += lines;

        display();

    }

    private void countEfficiency() {

        if (coffeePoints == 0) efficiency = linesOfCode * 10;
        else if (coffeePoints < 0) efficiency = linesOfCode * 100;
        else efficiency = (linesOfCode / coffeePoints) * 2;

    }

    private void display() {

        countEfficiency();

        TextView coffeePointsViev = (TextView) findViewById(R.id.coffee_points);
        coffeePointsViev.setText(String.valueOf(coffeePoints));

        TextView linesOfCodeViev = (TextView) findViewById(R.id.lines_of_code);
        linesOfCodeViev.setText(String.valueOf(linesOfCode));

        TextView efficiencyViev = (TextView) findViewById(R.id.efficiency);
        efficiencyViev.setText(String.valueOf(efficiency));

    }

    public void reset(View v) {

        coffeePoints = 0;
        linesOfCode = 0;
        efficiency = 0;
        display();


    }
}
