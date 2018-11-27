package com.wulias.project.bean;

import com.google.gson.annotations.SerializedName;
import com.wulias.project.base.BaseBean;

import java.io.Serializable;

/**
 * 广告页图片
 * Created by 曹小贼 on 2018/10/25.
 */

public class AdvertBean implements Serializable {

    @SerializedName("home_page")
    private String cover;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
