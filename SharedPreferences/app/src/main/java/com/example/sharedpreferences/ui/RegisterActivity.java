package com.example.sharedpreferences.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sharedpreferences.model.User;

import com.example.sharedpreferences.R;
import com.google.gson.Gson;

public class RegisterActivity extends AppCompatActivity {

    private EditText edUserName;
    private EditText edPassword;
    private EditText edt_confirm_password;
    private EditText edEmail;
    private EditText edPhone;
    private RadioGroup rgSex;
    private Button btnRegister;
    private ImageButton imbBack;

    //khai bao SharedPreferences
    private SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;

    //thu vien de bien nhung file java thanh file xml
    private final Gson gson = new Gson();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Register");
        //khai bao share pre
        sharedPreferences = getSharedPreferences(Utils.SHARE_PREFERENCES_APP, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        //lay du lieu
        anhxadulieu();
        taosukien();
    }

    void anhxadulieu()
    {
        edUserName = findViewById(R.id.edUserName);
        edPassword = findViewById(R.id.edPassword);
        edt_confirm_password = findViewById(R.id.edt_confirm_password);
        edEmail = findViewById(R.id.edEmail);
        edPhone = findViewById(R.id.edPhone);
        rgSex = findViewById(R.id.rgSex);
        btnRegister = findViewById(R.id.btnRegister);
        imbBack =findViewById(R.id.imbBack);

    }

    //bam nut dang ky va nut quay lai
    void taosukien()
    {
        btnRegister.setOnClickListener(v -> sukienRegister());
        imbBack.setOnClickListener(v -> finish());
    }

    void sukienRegister()
    {
        String userName = edUserName.getText().toString().trim(); //trim 2 dau de khong bi khoang trang
        String password = edPassword.getText().toString().trim();
        String confirmPassword = edt_confirm_password.getText().toString().trim();
        String email = edEmail.getText().toString().trim();
        String phone = edPhone.getText().toString().trim();
        // neu sex = 1 la nam, sex = 0 la nu
        int sex = 1;
        boolean isValid = checkUserName(userName) && checkPassword(password, confirmPassword); //nghia la neu nhu 2 cai checkUserName va checkPassword deu tra ve true het thi no se thuc hien
        if (isValid){ //isValid khong ghi gi het nghia la true
            // neu du lieu hop le, tao doi tuong user de luu vo share preference
            User userNew = new User();
            userNew.setUsername(userName);
            userNew.setPassword(password);
            userNew.setEmail(email);
            userNew.setPhoneNumber(phone);
            //may cai set... la no nam trong Class User ma ta da tao truoc do
            // lay radio button id dang duoc checked
            int sexSelected = rgSex.getCheckedRadioButtonId();
            //nghia la neu no la nu thi set no la nu, neu no khong phai la nu thi no se van la nam, tiet kiem code khong can phai if else
            if(sexSelected == R.id.rbFemale)
            {
                sex = 0;
            }
            userNew.setSex(sex);
            //vi user la object nen convert qua string voi format la json de luu vao share preference
            String userStr = gson.toJson(userName);
            editor.putString(Utils.KEY_USER, userStr);
            editor.commit();//đóng lại
            //dung Toast de show thong bao dang ky thanh cong
            Toast.makeText(RegisterActivity.this, "Đăng ký tài khoản thánh công", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private boolean checkUserName(String userName){
        if(userName.isEmpty()){
            edUserName.setError("Vui lòng nhập tên đăng nhập");
            return false;
        }

        if(userName.length() <= 5 ){
            edUserName.setError("Tên đăng nhập phải ít nhất 6 ký tự");
            return false;
        }
        return true;
    }

    private boolean checkPassword(String password, String confirmPassword){
        if(password.isEmpty())
        {
            edPassword.setError("Vui lòng nhập mật khẩu");
            return false;
        }
        if(password.length() <= 5){
            edPassword.setError("Mật khẩu phải lớn hơn 5 ký tự");
            return false;
        }
        if(!password.equals(confirmPassword))
        {
            edt_confirm_password.setError("Xác nhận mật khẩu không trùng khớp");
            return false;
        }
        return true;
    }
}