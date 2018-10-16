package com.wulias.project.bean;

import com.google.gson.annotations.SerializedName;
import com.wulias.project.base.BaseVo;

/**
 * Created by 曹小贼 on 2018/10/16.
 */

public class RegistVo extends BaseVo {

    @SerializedName("user_login")
    private String userName;
    @SerializedName("user_nickname")
    private String userNickname;
    @SerializedName("user_password")
    private String userPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
