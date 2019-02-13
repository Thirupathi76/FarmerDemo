package com.demo.farmerdemo.response;

import com.google.gson.annotations.SerializedName;

public class SignupResponse {

    @SerializedName("error")
    private boolean err;

    @SerializedName("message")
    private String msg;

    public SignupResponse(boolean err, String msg) {
        this.err = err;
        this.msg = msg;
    }

    public boolean isErr() {
        return err;
    }

    public String getMsg() {
        return msg;
    }
}
