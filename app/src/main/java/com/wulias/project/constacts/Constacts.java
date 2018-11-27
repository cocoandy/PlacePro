package com.wulias.project.constacts;

/**
 * Created by Gavin
 * 2018/9/29
 */
public interface Constacts {

    interface BASE{
        String BASE_URL = "http://jumu.jukest.com/app/";    //网址共同
    }


    interface INTENT {
        String KEY_PAGE_TYPE = "page_type"; //指定界面
        String KEY_SEARCH_VALUE = "search_value";//输入查询的条件
    }

    interface RESULTCODE {
        int CODE_SEARCH_VALUE = 10;//查询界面的code
    }



    String MD5_KEY_VALUE_END = "JKWL";    //
    String MD5_KEY_END = "JMCM123456";    //网址共同

    /**
     * 关于时间的常量
     */
    interface TimeKey {
        int REFRESHLOADMORE_TIME_OUT = 2; //刷新超时时间

    }

    /**
     * 传参的key
     */
    interface Key {
        String KEY_GROUP_ID = "group_id"; //影院组id
        String KEY_CINEMA_ID = "cinema_id"; //电影id
        String KEY_CINEMA_NAME = "cinema_name"; //电影名称
        String KEY_TICKET_FLAG = "ticket_flag"; //扫码结果（票的二维码内容）
        String KEY_SP_NAME_MAIN = "sp_main"; //保存组Id和影院信息
        String KEY_LOGIN_FORGET = "login_forget";
        String KEY_HTTP_SIGN = "sign";//请求验证

        String KEY_SEARCH_VALUE = "search_value";//查询条件
    }

    /**
     * 返回的code
     */
    interface ResultCode {
        int CODE_PERMISSIONS_CALL_CAMERA = 10;//设置摄像头权限返回值
    }

    interface SPKey {
        public static final String TABLE_NAME_MAIN = "sp_name_main";

        public static final String TABLE_KEY_ADVERT = "sp_key_advert";//广告文件名
    }

}
