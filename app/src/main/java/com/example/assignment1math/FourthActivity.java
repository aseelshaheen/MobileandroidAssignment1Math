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

public class FourthActivity extends AppCompatActivity {
    private RadioGroup grpResults;
    private Button btnGo3;
    private Button btnPrevious3;
    private CheckBox cboxResult3;
    private TextView txResult3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        setupViews();
    }

    public void setupViews(){
        grpResults = findViewById(R.id.grpResults);
        btnGo3 = findViewById(R.id.btnGo3);
        btnPrevious3 = findViewById(R.id.btnPrevious3);
        cboxResult3 = findViewById(R.id.cboxResult3);
        txResult3 = findViewById(R.id.txResult3);

        cboxResult3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int selectedId = grpResults.getCheckedRadioButtonId();
                if (isChecked) {
                    txResult3.setVisibility(View.VISIBLE);
                    if (selectedId != -1) {
                        RadioButton selectedRadioButton = findViewById(selectedId);
                        String selectedValue = selectedRadioButton.getText().toString().trim();
                        if ("666".equals(selectedValue)) {
                            txResult3.setText("Good Job");
                        } else {
                            txResult3.setText("Wrong : The Correct Answer Is 666");
                        }
                    }
                }
            }
        });


        btnGo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FourthActivity.this, FifthActivity.class);
                startActivity(intent);
            }
        });

        btnPrevious3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FourthActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });



    }
}