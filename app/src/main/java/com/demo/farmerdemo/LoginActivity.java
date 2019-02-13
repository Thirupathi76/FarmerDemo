package com.demo.farmerdemo;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    Button login;
    EditText et_username, et_password;
    TextView forgot_pwd;

    String user_name, password;
    TextView skip_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        skip_login = findViewById(R.id.skip_login);
//        signup_tv = findViewById(R.id.signup_tv);

        skip_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, NavProfileActivity.class));
            }
        });


        // sign up

        String sth = "Not registered yet? ";
        String sth2 = sth + "Sign Up";
        SpannableString ss = new SpannableString(sth2);
//        ss.setSpan(new StyleSpan(Typeface.BOLD), sth.length(), sth2.length(), 0);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                Toast.makeText(MainActivity.this, "Sign up", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };

        ss.setSpan(clickableSpan, sth.length(), sth2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new StyleSpan(Typeface.BOLD), sth.length(), ss.length(), 0);
        TextView textView = findViewById(R.id.signup_tv);
        textView.setText(ss);
//        textView.setTextColor(Color.BLACK);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(Color.TRANSPARENT);

        login = findViewById(R.id.btn_login);
        forgot_pwd = findViewById(R.id.forgot_pwd);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*boolean isFormValid = true;

                user_name = et_username.getText().toString().trim();
                password = et_password.getText().toString().trim();
                if (user_name.isEmpty()){
                    isFormValid = false;
                    et_username.setError("Enter Username");
                }
                if (password.isEmpty()){
                    isFormValid = false;
                    et_password.setError("Enter Password");
                }
                if (isFormValid) {
                    AppService service = AppApi.createAppService(LoginActivity.this);
                    Call<LoginResponse> responseCall = service.validateUser(user_name, password);
                    responseCall.enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                            if (response.isSuccessful()){
                                if (response.body().isErr()){
                                    startActivity(new Intent(LoginActivity.this, NavProfileActivity.class));
                                    Log.e("Response ", response.body().getMsg());
                                    Toast.makeText(LoginActivity.this, "Status "+response.body().getMsg(), Toast.LENGTH_SHORT).show();
                                } else {
                                    Log.e("Response ", response.body().getMsg());
                                    Toast.makeText(LoginActivity.this, "Status "+response.body().getMsg(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {
                            Log.e("Error", t.getMessage());
                        }
                    });

                }*/

                startActivity(new Intent(LoginActivity.this, NavProfileActivity.class));
            }
        });
    }
}
