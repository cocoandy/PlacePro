package com.wulias.project.constacts;

/**
 * Created by Gavin
 * 2018/9/29
 */
public interface Constacts {
    String BASE_URL = "http://test.jukest.com/Api/";//
    String GROUP_ID = "group_id"; //影院组id
    String CINEMA_ID = "cinema_id"; //电影id
    String CINEMA_NAME = "cinema_name"; //电影名称
    String TICKET_FLAG = "ticket_flag"; //扫码结果（票的二维码内容）

    String SP_NAME_MAIN = "sp_main"; //保存组Id和影院信息

   int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;
   int MY_PERMISSIONS_REQUEST_CALL_CAMERA = 2;

   int REFRESHLOADMORE_TIME_OUT = 2; //舒心超时时间

    String LOGIN_FORGET = "login_forget";



}
