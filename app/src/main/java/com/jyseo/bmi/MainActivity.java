package com.jyseo.bmi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit_cm;
    EditText edit_kg;

    Button btnCal;
    Button acLog;

    TextView txt_result_bmi;
    TextView txt_result_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_cm = findViewById(R.id.edit_cm);
        edit_kg = findViewById(R.id.edit_kg);
        btnCal = findViewById(R.id.btnCal);
        acLog = findViewById(R.id.ac_login);
        txt_result_bmi = findViewById(R.id.txt_result_bmi);
        txt_result_msg = findViewById(R.id.txt_result_msg);


        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String bringCm = edit_cm.getText().toString();
                String bringKg = edit_kg.getText().toString();





                // 키와 몸무게가 모두 입력되었는지 확인
                if (bringCm.equals("")) {
                    Toast.makeText(getApplicationContext(), "키를 입력해 주세요.", Toast.LENGTH_SHORT).show();
                } else if (bringKg.equals("")) {
                    Toast.makeText(getApplicationContext(), "몸무게를 입력해 주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    // 키와 몸무게 모두 입력
                    //  bmi 값 =   60 / ((180*0.01) * (180*0.01))
                    // bmi 계산  몸무게 / ((키*0.01) * (키*0.01))
                    // /**
                    //                 * 1. 문자를 숫자로 바꾸는 방법
                    //                 *      "170" -> 170
                    //                 *
                    //                 */
                    int changeCm = Integer.parseInt(bringCm);
                    int changeKg = Integer.parseInt(bringKg);

                    // bmi 값
                    double resultBmi = changeKg / ((changeCm * 0.01) * (changeCm * 0.01));
                    Toast.makeText(getApplicationContext(), "bmi 결과값은 == " + resultBmi, Toast.LENGTH_SHORT).show();

                    String resultMsg="";

                    if(resultBmi >= 40){
                        resultMsg = "고도비만]";
                    } else if(resultBmi >= 30){
                        resultMsg = "비만]";
                    } else if(resultBmi >= 25){
                        resultMsg = "과체중]";
                    } else if(resultBmi >= 20){
                        resultMsg = "정상]";
                    } else {
                        resultMsg = "저체중]";
                    }

                    // bmi 결과값과 결과에 따른 범이를 텍스트뷰에 입력한다.

                    int finalBmi = (int) resultBmi;
                    txt_result_bmi.setText("BMI : " + finalBmi);
                    txt_result_msg.setText("결과는 [" + resultMsg);

                }

            }
        });

        acLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , LoginActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "로그인 화면으로 돌아갑니다", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
