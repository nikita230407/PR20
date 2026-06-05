package com.example.pz20belyaevvadim;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

public class SecondActivity extends AppCompatActivity {

    private GestureDetectorCompat gestureDetector;
    private RelativeLayout mainLayout;
    private TextView tvCounter;
    private Button btnBack;
    private int counter = 0;

    private static final int SWIPE_MIN_DISTANCE = 100;
    private static final int SWIPE_MIN_VELOCITY = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        mainLayout = findViewById(R.id.main_layout);
        tvCounter = findViewById(R.id.tvCounter);
        btnBack = findViewById(R.id.btnBack);

        tvCounter.setText("Счёт: " + counter);

        gestureDetector = new GestureDetectorCompat(this, new SwipeGestureListener());

        mainLayout.setOnTouchListener((v, event) -> gestureDetector.onTouchEvent(event));

        // Кнопка "Назад"
        btnBack.setOnClickListener(v -> finish());
    }

    private class SwipeGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float diffX = e2.getX() - e1.getX();
            float diffY = e2.getY() - e1.getY();

            if (Math.abs(diffX) > Math.abs(diffY) &&
                    Math.abs(diffX) > SWIPE_MIN_DISTANCE &&
                    Math.abs(velocityX) > SWIPE_MIN_VELOCITY) {

                if (diffX > 0) {
                    counter++;
                    Toast.makeText(SecondActivity.this, "→ Вправо: " + counter, Toast.LENGTH_SHORT).show();
                } else {
                    counter--;
                    Toast.makeText(SecondActivity.this, "← Влево: " + counter, Toast.LENGTH_SHORT).show();
                }
                tvCounter.setText("Счёт: " + counter);
                return true;
            }
            return false;
        }
    }
}