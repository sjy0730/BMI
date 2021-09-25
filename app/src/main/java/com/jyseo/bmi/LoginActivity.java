package com.jyseo.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText editId;
    EditText editPwd;

    AppCompatButton btnLogin;
    AppCompatButton btnJoin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3);

        editId = findViewById(R.id.edit_id);
        editPwd = findViewById(R.id.edit_pwd);

        btnLogin = findViewById(R.id.btn_login);
        btnJoin = findViewById(R.id.btn_join);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLogin();
            }
        });

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext() , "회원가입 페이지로 이동합니다." , Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void goLogin(){

        String id = "jyseo";
        String pwd = "1234";

        /**
         * 아이디가 입력되었는지 체크
         */
        if (editId.getText().toString().equals("")){
            Toast.makeText(getApplicationContext() , "아이디를 입력해주세요." , Toast.LENGTH_SHORT).show();
            return;
        }

        /**
         * 비밀번호가 입력되었는지 체크
         */

        if (editPwd.getText().toString().equals("")){
            Toast.makeText(getApplicationContext() , "비밀번호를 입력해주세요." , Toast.LENGTH_SHORT).show();
            return;
        }

        /**
         * 입력된 값이 아이디와 비밀번호가 실제 맞는지 체크
         */

        if (editId.getText().toString().equals(id) && editPwd.getText().toString().equals(pwd)){
            //로그인 O

            Intent intent = new Intent(LoginActivity.this , MainActivity.class);
            startActivity(intent);

        } else {
            //로그인 X
            Toast.makeText(getApplicationContext() , "아이디와 비밀번호가 맞는지 확인해주세요." , Toast.LENGTH_SHORT).show();
        }
    }
}