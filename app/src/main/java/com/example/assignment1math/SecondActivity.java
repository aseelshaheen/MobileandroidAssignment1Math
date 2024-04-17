package com.example.assignment1math;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    private ListView listContents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setupViews();

    }

    public void setupViews(){
        //store the topics in the list view
        String [] contents = {"Rate Of Change","First Derivative","Extreme Values","Indefinite Integral"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1 ,contents);
        listContents = findViewById(R.id.listContents);
        listContents.setAdapter(adapter);

        listContents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override   //move to each activity
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                if ("Rate Of Change".equals(item)) {
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    startActivity(intent);
                } else if("First Derivative".equals(item)) {
                    Intent intent = new Intent(SecondActivity.this, FourthActivity.class);
                    startActivity(intent);
                }else if ("Extreme Values".equals(item)){
                    Intent intent = new Intent(SecondActivity.this, FifthActivity.class);
                    startActivity(intent);
                }else if ("Indefinite Integral".equals(item)){
                    Intent intent = new Intent(SecondActivity.this, SixthActivity.class);
                    startActivity(intent);
                }

            }
        });


    }
//    @Override
//    protected void onStop() {
//        super.onStop();
//        moveTaskToBack(true); // move the app to the background
//    }
}