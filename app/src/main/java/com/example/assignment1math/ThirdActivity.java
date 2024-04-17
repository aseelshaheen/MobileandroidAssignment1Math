package com.example.assignment1math;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity {

    private EditText edtResult1;
    private TextView txFeedBack;
    private CheckBox cboxResult;
    private Button btnGo2;
    private Button btnPrevious2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        setupViews();

    }

    public void setupViews(){
        edtResult1 = findViewById(R.id.edtResult1);
        txFeedBack = findViewById(R.id.txFeedBack);
        cboxResult = findViewById(R.id.cboxResult);
        btnGo2 = findViewById(R.id.btnGo2);
        btnPrevious2 = findViewById(R.id.btnPrevious2);



        cboxResult.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String result = edtResult1.getText().toString();
                if (isChecked) {
                    txFeedBack.setVisibility(View.VISIBLE);
                    if ("8".equals(result)) {
                        txFeedBack.setText("Good Job");
                    } else {
                        txFeedBack.setText("Wrong : The Correct Answer Is 8");
                    }
                } else {
                    txFeedBack.setVisibility(View.INVISIBLE);
                }
            }
        });


        btnGo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, FourthActivity.class);
                startActivity(intent);
            }
        });

        btnPrevious2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
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