package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {
TextView tvUserNameC, tvPasswordC;
Button btnBackC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        addControl();
        Bundle bundle = getIntent().getExtras();
        String username = bundle.getString("username");
        String password = bundle.getString("password");
        tvUserNameC.setText(username);
        tvPasswordC.setText(password);
        btnBackC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    public void addControl(){
        tvUserNameC = findViewById(R.id.tvUsername);
        tvPasswordC = findViewById(R.id.tvPassword);
        btnBackC = findViewById(R.id.btnBack);
    }

}