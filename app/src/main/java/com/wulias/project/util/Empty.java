package com.wulias.project.util;

/**
 * Created by 曹小贼 on 2018/10/9.
 */

public class Empty {
    public static boolean isEmpty(String vlue){
        if (vlue==null){
            return true;
        }else if ("".equals(vlue.trim())){
            return true;
        }else {
            return false;
        }
    }
}
