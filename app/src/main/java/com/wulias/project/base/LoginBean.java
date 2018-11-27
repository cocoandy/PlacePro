package com.wulias.project.base;

import java.io.Serializable;

/**
 * Created by 曹小贼 on 2018/10/30.
 */

public class LoginBean implements Serializable {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
