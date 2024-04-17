package com.example.assignment1math;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FifthActivity extends AppCompatActivity {
    private Button btnGo4;
    private Button btnPrevious4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        setupViews();

    }

    public void setupViews(){
        btnGo4 = findViewById(R.id.btnGo4);
        btnPrevious4 = findViewById(R.id.btnPrevious4);

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

}