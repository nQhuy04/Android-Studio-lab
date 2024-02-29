package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText edName;
Button btnOke;
TextView tvShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ánh xạ
        edName = findViewById(R.id.edName); //cái edName có thể đặt tên khác nhau được, đang đặt giống nhau để dễ làm hơn
        btnOke = findViewById(R.id.btnOk);
        tvShow = findViewById(R.id.tvShow);

        btnOke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //lấy dữ liệu
                String name = edName.getText().toString();
                //gán dữ liệu
                if (name.isEmpty())
                    tvShow.setText("Vui lòng nhập tên.");
                else
                    tvShow.setText("Xin Chào " + name);


            }
        });

    }
}