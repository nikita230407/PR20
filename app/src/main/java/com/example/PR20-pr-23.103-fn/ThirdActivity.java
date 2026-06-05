package com.example.pz20belyaevvadim;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);

        CheckBox chkOption = findViewById(R.id.chkOption);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        SwitchCompat switchToggle = findViewById(R.id.switchToggle);
        Button btnBack = findViewById(R.id.btnBack);

        chkOption.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(ThirdActivity.this, "✓ Флажок включён", Toast.LENGTH_SHORT).show();
            }
        });

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radio1) {
                Toast.makeText(ThirdActivity.this, "Выбран вариант 1", Toast.LENGTH_SHORT).show();
            } else if (checkedId == R.id.radio2) {
                Toast.makeText(ThirdActivity.this, "Выбран вариант 2", Toast.LENGTH_SHORT).show();
            }
        });

        switchToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String status = isChecked ? "ВКЛ" : "ВЫКЛ";
            Toast.makeText(ThirdActivity.this, "Переключатель: " + status, Toast.LENGTH_SHORT).show();
        });

        btnBack.setOnClickListener(v -> finish());
    }
}