package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.TextUtilsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText edUserNameC, edPasswordC;
Button btnloginC, btncancelC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        //viet su kien btnLogin
        btnloginC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edUserNameC.getText().toString().trim();
                String password = edPasswordC.getText().toString().trim();
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("password", password);
                startActivity(intent);
            }
        });
        btncancelC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void addControl()
    {
        edUserNameC = findViewById(R.id.edUserName);
        edPasswordC = findViewById(R.id.edPassword);
        btnloginC = findViewById(R.id.btnlogin);
        btncancelC = findViewById(R.id.btncancel);
    }
}