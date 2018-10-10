package com.wulias.project.bean;

import com.wulias.project.base.BaseBean;

/**
 * Created by 曹小贼 on 2018/8/17.
 */

public class SelfBean extends BaseBean {
    private int type;//0：用户信息 1：订单 2：工具 3：标题 4：其余可跳转项
    private String msg;
    private String title;
    private int res;

    public SelfBean(String title,int res,int type) {
        this.title = title;
        this.res = res;
        this.type = type;
    }
    public SelfBean(String title,String msg,int res,int type) {
        this.title = title;
        this.msg = msg;
        this.res = res;
        this.type = type;
    }
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }
}
