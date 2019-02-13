package com.demo.farmerdemo;

import android.app.ProgressDialog;
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
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.farmerdemo.appapi.AppApi;
import com.demo.farmerdemo.appapi.AppService;
import com.demo.farmerdemo.response.SignupResponse;
import com.demo.farmerdemo.utils.Constants;
import com.demo.farmerdemo.utils.SampleDB;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogisticRegistration extends AppCompatActivity implements View.OnClickListener {

    private EditText name, email, mobile, password, whatsapp_number, state, district, mandal,
            villages, crop_size, crop_type, confirm_password;

    private String u_name, u_email, u_mobile, u_password, u_whatsapp_number,
            u_state, u_district, u_mandal, u_villages, u_crop_size, u_crop_type, u_confirm_password;

    private TextView signup;

    private static final String MOBILE_PATTERN = "^[6789]\\d{9}$";
    public static final String EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private static final String NAME_PATTERN = "[a-zA-Z., ]+([ '-][a-zA-Z., ]+)*";
    private ProgressDialog dialog;
    private String otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logistic_signup);

        signup = findViewById(R.id.btn_signup);
        signup.setOnClickListener(this);
        name = findViewById(R.id.et_username);
        mobile = findViewById(R.id.et_farmer_number);
        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        whatsapp_number = findViewById(R.id.et_whatsapp_number);
        state = findViewById(R.id.et_state);
        district = findViewById(R.id.et_district);
        mandal = findViewById(R.id.et_mandal);
        villages = findViewById(R.id.et_village);
        crop_size = findViewById(R.id.et_crop_size);
        crop_type = findViewById(R.id.et_crop_type);
        confirm_password = findViewById(R.id.et_confirm_password);

        signup = findViewById(R.id.btn_signup);

        signup.setOnClickListener(this);

        String sth = "Already have an account? ";
        String sth2 = sth + "Sign In";
        SpannableString ss = new SpannableString(sth2);
//        ss.setSpan(new StyleSpan(Typeface.BOLD), sth.length(), sth2.length(), 0);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                startActivity(new Intent(LogisticRegistration.this, MainActivity.class));
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
        TextView textView = findViewById(R.id.signin_tv);
        textView.setText(ss);
//        textView.setTextColor(Color.BLACK);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(Color.TRANSPARENT);


    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_signup) {

            u_name = name.getText().toString();
            u_mobile = mobile.getText().toString();
            u_email = email.getText().toString();
            u_password = password.getText().toString();
            u_whatsapp_number = whatsapp_number.getText().toString();
            u_state = state.getText().toString();
            u_district = district.getText().toString();
            u_mandal = mandal.getText().toString();
            u_villages = villages.getText().toString();
            u_crop_size = crop_size.getText().toString();
            u_crop_type = crop_type.getText().toString();
            u_confirm_password = confirm_password.getText().toString();
            boolean isFormValid = true;
            if (!u_name.matches(NAME_PATTERN) || u_name.length() < 3 || u_name.length() > 30) {
                name.setError("User name invalid");
                isFormValid = false;
            }
            if (!u_email.matches(EMAIL_PATTERN) || u_email.equals("")) {
                isFormValid = false;
                email.setError("Email invalid");
            }
            if (!u_mobile.matches(MOBILE_PATTERN) || u_mobile.equals("")) {
                isFormValid = false;
                mobile.setError("Mobile number invalid");
            }
            /*if (u_city.equals("") || u_city.isEmpty()) {
                isFormValid = false;
                city.setError("Enter city name");
            }*/
            if (u_password.length() < 6) {
                isFormValid = false;
                password.setError("Min 6 characters");
            }
           /* if (Constants.getPrefernce(FarmerSignUp.this, Constants.YOU_IMAGE).isEmpty())
                isFormValid = false;*/

            if (isFormValid) {
//                String photo_path = Constants.getPrefernce(FarmerSignUp.this, Constants.YOU_IMAGE);
                new SampleDB(this).insertUserData(u_name, u_email, "male", u_mobile,
                        u_email, u_password);


                Toast.makeText(this, "You're Signed in", Toast.LENGTH_SHORT).show();
                Constants.setPrefernce(LogisticRegistration.this, Constants.NAME, u_name);
                Constants.setPrefernce(LogisticRegistration.this, Constants.PASSWORD, u_password);
                Constants.setPrefernce(LogisticRegistration.this, Constants.PHONE, u_mobile);
                Constants.setPrefernce(LogisticRegistration.this, Constants.EMAIL, u_email);
                Constants.setPrefernce(LogisticRegistration.this, Constants.CITY, u_district);


                AppService service = AppApi.createAppService(LogisticRegistration.this);
                Call<SignupResponse> call = service.signUpData(u_name,
                        u_mobile, u_email, u_password, u_whatsapp_number,
                        u_state, u_district, u_mandal, u_villages, u_crop_size, u_crop_type, u_confirm_password);

                call.enqueue(new Callback<SignupResponse>() {
                    @Override
                    public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {

                        if (response.isSuccessful()) {
                            if (response.body().isErr()) {
                                startActivity(new Intent(LogisticRegistration.this, LoginActivity.class));
                                Log.e("Response ", response.body().getMsg());
                                Toast.makeText(LogisticRegistration.this, "Status " + response.body().getMsg(), Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Log.e("Response ", response.body().getMsg());
                            Toast.makeText(LogisticRegistration.this, "Status " + response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<SignupResponse> call, Throwable t) {
                        Log.e("Error", t.getMessage());
                    }
                });


            }
        }
    }
}
