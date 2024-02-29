package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TinhToanActivity extends AppCompatActivity {

    EditText edSoA, edSoB;
    Button btnCong, btnTru, btnNhan, btnChia;
    TextView tvKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinh_toan);

        //ánh xạ
        edSoA = findViewById(R.id.edSoA);
        edSoB = findViewById(R.id.edSoB);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        tvKetQua = findViewById(R.id.tvKetQua);

        //Tính toán
        btnCong.setOnClickListener(v -> TinhToan("cong"));
        btnTru.setOnClickListener(v -> TinhToan("tru"));
        btnNhan.setOnClickListener(v -> TinhToan("nhan"));
        btnChia.setOnClickListener(v -> TinhToan("chia"));
    }// end create

    //Hiển thị dữ liệu
    void ShowData(int rs){
        tvKetQua.setText(String.valueOf(rs));
    }

    //Tính toán
    void TinhToan (String loai){
        String txtSoA = edSoA.getText().toString();
        String txtSoB = edSoB.getText().toString();
        if(txtSoA.isEmpty() || txtSoB.isEmpty()){
            tvKetQua.setText("Vui lòng nhập A và B");
            return;
        }
        int a = Integer.valueOf(txtSoA);
        int b = Integer.valueOf(txtSoB);
        // check loai

        switch (loai){
            case "cong":
                ShowData(a + b);
                break;
            case "tru":
                ShowData(a - b);
                break;
            case "nhan":
                ShowData(a * b);
                break;
            case "chia":
                if (b == 0)
                    tvKetQua.setText("Không thể chia");
                else {
                    double rs = (double) a/b;
                    tvKetQua.setText(String.valueOf(rs));
                }
                break;
        }
    }
}