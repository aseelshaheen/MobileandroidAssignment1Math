package com.example.assignment1math;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FifthActivity extends AppCompatActivity {
    private Button btnGo4;
    private Button btnPrevious4;
    private CheckBox cBoxResult5;
    private TextView txResult5;
    private RadioGroup grpResult5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        setupViews();

    }

    public void setupViews(){
        btnGo4 = findViewById(R.id.btnGo4);
        btnPrevious4 = findViewById(R.id.btnPrevious4);
        grpResult5 = findViewById(R.id.grpResult5);
        txResult5 = findViewById(R.id.txResult5);
        cBoxResult5 = findViewById(R.id.cBoxResult5);

        cBoxResult5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int selectedId = grpResult5.getCheckedRadioButtonId();
                if (isChecked) {
                    txResult5.setVisibility(View.VISIBLE);
                    if (selectedId != -1) {
                        RadioButton selectedRadioButton = findViewById(selectedId);
                        String selectedValue = selectedRadioButton.getText().toString().trim();
                        if ("1,No maximum".equals(selectedValue)) {
                            txResult5.setText("Good Job");
                        } else {
                            txResult5.setText("Wrong : The Correct Answer Is 666");
                        }
                    }
                }
            }
        });


        btnPrevious4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FifthActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        btnGo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FifthActivity.this, FifthActivity.class);
                startActivity(intent);
            }
        });

    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        moveTaskToBack(true); // move the app to the background
//    }

}