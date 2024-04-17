package com.example.assignment1math;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SixthActivity extends AppCompatActivity {
    private TextView txResult6;
    private CheckBox cboxResult6;
    private Spinner spnResults;
    private Button btnPrevious6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);
        setupViews();
    }

    public void setupViews() {
        txResult6 = findViewById(R.id.txResult6);
        spnResults = findViewById(R.id.spnResults);
        cboxResult6 = findViewById(R.id.cboxResult6);
        btnPrevious6 = findViewById(R.id.btnPrevious6);

        // put options in the spinner
        String[] options = {"15x5+32x2−9x+c", "15x6+32x2−9x", "15x5+32x2−9x", "15x5+32x−9x+c"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnResults.setAdapter(adapter);

        // check answer
        cboxResult6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String selectedOption = spnResults.getSelectedItem().toString();
                if (isChecked) {
                    txResult6.setVisibility(View.VISIBLE);
                    if (selectedOption.equals("15x5+32x2−9x+c")) {
                        txResult6.setText("Good Job");
                    } else {
                        txResult6.setText("Wrong : The Correct Answer Is 15x5+32x2−9x+c ");
                    }
                } else {

                    txResult6.setVisibility(View.INVISIBLE);
                }
            }
        });


        btnPrevious6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SixthActivity.this, SecondActivity.class);
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

