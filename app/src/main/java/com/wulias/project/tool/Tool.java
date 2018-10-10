package com.wulias.project.tool;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

import com.github.promeg.pinyinhelper.Pinyin;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wulias.project.base.App;
import com.wulias.project.base.BaseInfo;
import com.wulias.project.base.BaseTool;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 工具
 * Created by Gavin
 * 2018/9/29
 */
public class Tool extends BaseTool{

    /**
     * BaseApi 转为Map
     */
    public static Map<String, String> toMap(BaseInfo api) {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>() {
        }.getType();
        return gson.fromJson(gson.toJson(api), type);
    }

    /**
     * 对象转成json字符
     *
     * @param object
     * @return
     */
    public static String beanToString(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }


    /**
     * 判断字符串是否是空的
     *
     * @param vlue
     * @return
     */
    public static boolean isEmpty(String vlue) {
        if (vlue == null) {
            return true;
        } else if ("".equals(vlue.trim())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断对象是否是空的
     *
     * @param vlue
     * @return
     */
    public static boolean isEmpty(Object vlue) {
        if (vlue == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断列表是否是空的
     *
     * @param vlue
     * @return
     */
    public static boolean isEmpty(List vlue) {
        if (vlue == null) {
            return true;
        } else if (vlue.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 文字转拼音
     */
    public static String transformPinYin(String character) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < character.length(); i++) {
            buffer.append(Pinyin.toPinyin(character.charAt(i)));
        }
        return buffer.toString();
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static boolean isNotificationEnabled() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //8.0手机以上
            if (((NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE)).getImportance() == NotificationManager.IMPORTANCE_NONE) {
                return false;
            }
        }

        String CHECK_OP_NO_THROW = "checkOpNoThrow";
        String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";

        AppOpsManager mAppOps = (AppOpsManager) getContext().getSystemService(Context.APP_OPS_SERVICE);
        ApplicationInfo appInfo = getContext().getApplicationInfo();
        String pkg = getContext().getApplicationContext().getPackageName();
        int uid = appInfo.uid;

        Class appOpsClass = null;

        try {
            appOpsClass = Class.forName(AppOpsManager.class.getName());
            Method checkOpNoThrowMethod = appOpsClass.getMethod(CHECK_OP_NO_THROW, Integer.TYPE, Integer.TYPE,
                    String.class);
            Field opPostNotificationValue = appOpsClass.getDeclaredField(OP_POST_NOTIFICATION);

            int value = (Integer) opPostNotificationValue.get(Integer.class);
            return ((Integer) checkOpNoThrowMethod.invoke(mAppOps, value, uid, pkg) == AppOpsManager.MODE_ALLOWED);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
