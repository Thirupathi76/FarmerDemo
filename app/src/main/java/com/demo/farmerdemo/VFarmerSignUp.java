package com.demo.farmerdemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.farmerdemo.utils.Constants;
import com.demo.farmerdemo.utils.SampleDB;

public class VFarmerSignUp extends AppCompatActivity implements View.OnClickListener {

    private EditText name, email, mobile, city, password;
    private String u_name, u_email, u_mobile, u_city, u_password;
    private TextView signup, cap_img;
    
    private static final String MOBILE_PATTERN = "^[6789]\\d{9}$";
    public static final String EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private static final String NAME_PATTERN = "[a-zA-Z., ]+([ '-][a-zA-Z., ]+)*";
    private ProgressDialog dialog;
    private String otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vfarmer_signup);

        signup = findViewById(R.id.btn_signup);


        signup.setOnClickListener(this);
        /*name = findViewById(R.id.et_username);
        mobile = findViewById(R.id.et_mobile);
        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);

        signup = findViewById(R.id.btn_signup);


        signup.setOnClickListener(this);

        String sth = "Already have an account? ";
        String sth2 = sth+"Sign In";
        SpannableString ss = new SpannableString(sth2);
//        ss.setSpan(new StyleSpan(Typeface.BOLD), sth.length(), sth2.length(), 0);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                startActivity(new Intent(FarmerSignUp.this, MainActivity.class));
//                Toast.makeText(MainActivity.this, "Sign up", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };
        ss.setSpan(clickableSpan, sth.length(),sth2.length(),  Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new StyleSpan(Typeface.BOLD), sth.length(), ss.length(), 0);
        TextView textView = findViewById(R.id.signin_tv);
        textView.setText(ss);
//        textView.setTextColor(Color.BLACK);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(Color.TRANSPARENT);
*/
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_signup) {

            /*u_name = name.getText().toString();
            u_mobile = mobile.getText().toString();
            u_email = email.getText().toString();
            u_city = city.getText().toString();
            u_password = password.getText().toString();

            boolean isFromValid = true;
            if (!u_name.matches(NAME_PATTERN) || u_name.length() < 3 || u_name.length() > 30) {
                name.setError("User name invalid");
                isFromValid = false;
            }
            if (!u_email.matches(EMAIL_PATTERN) || u_email.equals("")) {
                isFromValid = false;
                email.setError("Email invalid");
            }
            if (!u_mobile.matches(MOBILE_PATTERN) || u_mobile.equals("")) {
                isFromValid = false;
                mobile.setError("Mobile number invalid");
            }
            if (u_city.equals("") || u_city.isEmpty()) {
                isFromValid = false;
                city.setError("Enter city name");
            } if (u_password.length()<6 ){
                isFromValid = false;
                password.setError("Min 6 characters");
            } if (Constants.getPrefernce(FarmerSignUp.this, Constants.YOU_IMAGE).isEmpty())
                isFromValid = false;

            if (true) {
//                String photo_path = Constants.getPrefernce(FarmerSignUp.this, Constants.YOU_IMAGE);
                new SampleDB(this).insertUserData(u_name, photo_path, u_city, "male", u_mobile,
                        u_email, u_password);
                Toast.makeText(this, "You're Signed in", Toast.LENGTH_SHORT).show();
                Constants.setPrefernce(VFarmerSignUp.this, Constants.NAME, u_name);
                Constants.setPrefernce(VFarmerSignUp.this, Constants.PASSWORD, u_password);
                Constants.setPrefernce(VFarmerSignUp.this, Constants.PHONE, u_mobile);
                Constants.setPrefernce(VFarmerSignUp.this, Constants.EMAIL, u_email);
                Constants.setPrefernce(VFarmerSignUp.this, Constants.CITY, u_city);


            }*/
            startActivity(new Intent(VFarmerSignUp.this, LoginActivity.class));
        }
        

    }
}
