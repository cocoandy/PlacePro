package com.wulias.project.bean.vo;

import com.google.gson.annotations.SerializedName;
import com.wulias.project.base.BaseVo;

/**
 * Created by 曹小贼 on 2018/10/16.
 */

public class LoginVo extends BaseVo{

    @SerializedName("user_login")
    private String userName;
    @SerializedName("user_password")
    private String userPassword;

    public LoginVo(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
