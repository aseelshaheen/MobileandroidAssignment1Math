package com.example.assignment1math;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FirstActivity extends AppCompatActivity {
    public static final String KEY_USERNAME = "aseel";
    public static final String KEY_PASSWORD = "123";
    public static final String KEY_FLAG = "FLAG";
    private EditText edtUsername;
    private EditText edtPassword;
    private CheckBox chkRemember;
    private SharedPreferences sharedPreferences;
    private Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        setupViews();
        setupSharedPreferences();
        checkSharedPreferences();
    }

    private void setupSharedPreferences() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    private void setupViews() {
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        chkRemember = findViewById(R.id.chkRemember);
        btnSignIn = findViewById(R.id.btnLogin);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredUsername = edtUsername.getText().toString();
                String enteredPassword = edtPassword.getText().toString();

                if (chkRemember.isChecked()) {  // save username and password to SharedPreferences

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_USERNAME, enteredUsername);
                    editor.putString(KEY_PASSWORD, enteredPassword);
                    editor.putBoolean(KEY_FLAG, true);
                    editor.apply();
                } else {
                    // clear username and password from SharedPreferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.remove(KEY_USERNAME);
                    editor.remove(KEY_PASSWORD);
                    editor.putBoolean(KEY_FLAG, false);
                    editor.apply();
                }

                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);  // start SecondActivity
                startActivity(intent);
            }
        });
    }

    private void checkSharedPreferences() {
        boolean rememberFlag = sharedPreferences.getBoolean(KEY_FLAG, false);
        if (rememberFlag) { //populate EditTexts with saved credentials and check the CheckBox
            String savedUsername = sharedPreferences.getString(KEY_USERNAME, "");
            String savedPassword = sharedPreferences.getString(KEY_PASSWORD, "");
            edtUsername.setText(savedUsername);
            edtPassword.setText(savedPassword);
            chkRemember.setChecked(true);
        }
    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        moveTaskToBack(true); // move the app to the background
//    }
}