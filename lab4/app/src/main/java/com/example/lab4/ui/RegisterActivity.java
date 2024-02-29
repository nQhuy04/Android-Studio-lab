package com.example.lab4.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.lab4.R;

public class RegisterActivity extends AppCompatActivity {
ImageButton imbBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Register");
        imbBack = findViewById(R.id.imbBack);
        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Thực hiện hành động quay trở lại trang đăng nhập ở đây
                // Ví dụ: mở Intent để khởi động Activity đăng nhập mới
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                // Kết thúc (finish) Activity hiện tại nếu bạn muốn
                finish();
            }
        });
    }
}