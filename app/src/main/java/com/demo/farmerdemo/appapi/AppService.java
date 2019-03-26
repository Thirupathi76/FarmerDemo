package com.demo.farmerdemo.appapi;

import com.demo.farmerdemo.response.LoginResponse;
import com.demo.farmerdemo.response.SignupResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AppService {

    @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponse> validateUser(
            @Field("username") String user_name,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("signup.php")
    Call<SignupResponse> signUpData(

            @Field("name") String u_name,
            @Field("mobile") String u_mobile,
            @Field("email") String u_email,
            @Field("password") String u_password,
            @Field("whatsapp_number") String u_whatsapp_number,
            @Field("state") String u_state,
            @Field("district") String u_district,
            @Field("mandal") String u_mandal,
            @Field("villages") String u_villages,
            @Field("crop_size") String u_crop_size,
            @Field("crop_type") String u_crop_type,
            @Field("confirm_password") String u_confirm_password
    );

    /*@FormUrlEncoded
    @POST("location_details.php")
    Call<LocationDetails> sendLocation(
            @Field("loc_det") String user_name,
            @Field("emp_id") String password
    );


    @FormUrlEncoded
    @POST("employeetracking_report.php")
    Call<ResponseReport> getTravelDetails(
            @Field("emp_id") String emp_id,
            @Field("report_type") String report_type,
            @Field("from_date") String from_date,
            @Field("to_date") String to_date
    );

    @FormUrlEncoded
    @POST("logout.php")
    Call<ResponseStatus> logoutData(
            @Field("emp_id") String emp_id,
            @Field("distance") String distance,
            @Field("login_first_rec_time") String login_first_rec_time,
            @Field("login_time") String login_time,
            @Field("logout_time") String logout_time,
            @Field("date") String date,
            @Field("last_lat") String lat,
            @Field("last_lon") String lon
    );

//    @Field("imei") String imei

    @FormUrlEncoded
    @POST("forgot_password.php")
    Call<ResponseStatus> getPassword(
            @Field("username") String user_name,
            @Field("mobile") String mobile,
            @Field("imei") String imei
    );*/

}
