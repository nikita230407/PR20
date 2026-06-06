package com.example.PR20-pr-23.103-fn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView appIcon;
    private boolean isImageVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appIcon = findViewById(R.id.appIcon);
        Button btnToSecond = findViewById(R.id.btnToSecond);
        Button btnToThird = findViewById(R.id.btnToThird);
        Button btnToggleImage = findViewById(R.id.btnToggleImage);

        // Кнопка перехода к свайпам
        btnToSecond.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });

        // Кнопка перехода к скроллу
        btnToThird.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
            startActivity(intent);
        });

        // Кнопка скрытия/показа картинки
        btnToggleImage.setOnClickListener(v -> {
            if (isImageVisible) {
                appIcon.setVisibility(View.GONE);
                isImageVisible = false;
            } else {
                appIcon.setVisibility(View.VISIBLE);
                isImageVisible = true;
            }
        });
    }
}
