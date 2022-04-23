package com.example.mvc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Khai báo
    private     EditText    edtEmail,edtPassword;
    private     TextView    tvMessage;
    private     Button      btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ánh xạ
        edtEmail    = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        tvMessage   = findViewById(R.id.tv_message);
        btnLogin    = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickLogin();
            }
        });
    }

    //Sự kiện đăng nhập
    private void clickLogin() {
        String strEmail     = edtEmail.getText().toString().trim();
        String strPassword  = edtPassword.getText().toString().trim();

        User user = new User(strEmail, strPassword);

        tvMessage.setVisibility(View.VISIBLE);
        if(user.isValidEmail() && user.isValidPassword()){
                tvMessage.setText("Đăng nhập thành công");
                tvMessage.setTextColor(getResources().getColor(R.color.purple_500));
        }else {
            tvMessage.setText("Đăng nhập không thành công");
            tvMessage.setTextColor(getResources().getColor(R.color.purple_200));
        }
    }
}