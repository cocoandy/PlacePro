package com.wulias.project.constacts;

/**
 * Created by Gavin
 * 2018/9/29
 */
public interface Constacts {
    String BASE_URL = "https://jumu.jukest.com/app/";    //网址共同


    /**
     * 关于时间的常量
     */
    interface TimeKey {
        int REFRESHLOADMORE_TIME_OUT = 2; //刷新超时时间

    }

    /**
     *传参的key
     */
    interface Key {
        String KEY_GROUP_ID = "group_id"; //影院组id
        String KEY_CINEMA_ID = "cinema_id"; //电影id
        String KEY_CINEMA_NAME = "cinema_name"; //电影名称
        String KEY_TICKET_FLAG = "ticket_flag"; //扫码结果（票的二维码内容）
        String KEY_SP_NAME_MAIN = "sp_main"; //保存组Id和影院信息
        String KEY_LOGIN_FORGET = "login_forget";
        String KEY_HTTP_SIGN = "sign";//请求验证
    }

    /**
     * 返回的code
     */
    interface ResultCode {
        int CODE_PERMISSIONS_CALL_CAMERA = 10;//设置摄像头权限返回值
    }

}
