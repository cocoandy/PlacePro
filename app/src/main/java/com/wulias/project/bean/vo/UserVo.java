package com.wulias.project.bean.vo;

import com.google.gson.annotations.SerializedName;
import com.wulias.project.base.BaseVo;

/**
 * Created by 曹小贼 on 2018/11/1.
 */

public class UserVo extends BaseVo {

    @SerializedName("user_id")
    private Long userId;

    public UserVo(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
