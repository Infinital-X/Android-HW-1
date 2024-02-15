package com.example.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = findViewById(R.id.button);
        Button b2 = findViewById(R.id.button2);
        Button b3 = findViewById(R.id.button3);

        LocalDateTime targetDateTime = LocalDateTime.of(2024, 2, 7, 8, 5);

        LocalDateTime currentDateTime = LocalDateTime.now();
        Duration duration = Duration.between(currentDateTime, targetDateTime);

        String msg = formatTimeLeft(duration.toDays(), duration.toHours() % 24, duration.toMinutes() % 60);

        b3.setOnClickListener(v -> Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show());

        b.setOnClickListener(v -> v.setBackgroundColor(generateRandomColor()));

        final int[] clicksCount = {0};

        b2.setOnClickListener( v -> ( ( Button ) v ).setText( ( "Click count: " + ++(clicksCount[0])) ) );
    }

    private int generateRandomColor() {
        Random random = new Random();
        return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
    private static String formatTimeLeft(long days, long hours, long minutes) {
        StringBuilder result = new StringBuilder();

        if (days > 0) {
            result.append(days).append(" days").append(" ");
        }

        if (hours > 0) {
            result.append(hours).append(" hours").append(" ");
        }

        if (minutes > 0) {
            result.append(minutes).append(" minutes");
        }

        return result.toString();
    }
}