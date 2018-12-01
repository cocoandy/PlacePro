package com.wulias.project.util;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Log;

import com.github.promeg.pinyinhelper.Pinyin;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wulias.project.base.BaseVo;
import com.wulias.project.base.BaseTool;
import com.wulias.project.constacts.Constacts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 工具
 * Created by Gavin
 * 2018/9/29
 */
public class Tool extends BaseTool {

    /**
     * BaseApi 转为Map
     */
    public static Map<String, String> toMap(BaseVo api) {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>() {}.getType();
        return gson.fromJson(gson.toJson(api), type);
    }

    /**
     * 转成ContentValues
     * @param object
     * @return
     */
    public static ContentValues toContentValues(Object object){
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>() {}.getType();
        return gson.fromJson(gson.toJson(object), type);
    }

    /**
     * 请求参数对象转成map并加入校验参数
     * BaseApi 转为Map
     */
    public static Map<String, String> toApiMap(BaseVo api) {
        Map<String, String> map = toMap(api);
        List<String> keyList = new ArrayList<>(map.keySet());
        //对key列表排序
        Collections.sort(keyList);
        //取值
        StringBuffer sb = new StringBuffer();
        for (String key : keyList) {
            sb.append(map.get(key));
            sb.append(Constacts.MD5_KEY_VALUE_END);
        }
        sb.append(Constacts.MD5_KEY_END);
        //对值进行md5加密
        map.put(Constacts.Key.KEY_HTTP_SIGN, md5(sb.toString()));
        Log.e("TAG_OO",beanToString(map));
        return map;
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


    /**
     * 设置通知栏通知
     *
     * @return
     */
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

    /**************************     加密   ********************************/

    /***
     * MD5加密
     * @param string
     * @return
     */
    public static String md5(String string) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes());
            StringBuilder result = new StringBuilder();
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result.append(temp);
            }
            return result.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 获取下载地址
     * @return
     */
    public static String getDir() {
        StringBuffer sb = new StringBuffer();
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            sb.append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath());
            return sb.toString();
        } else {
            File f = getContext().getCacheDir();
            if (null != f) {
                sb.append(f.getAbsolutePath());
                sb.append("/");
                return sb.toString();
            }

        }
        return null;
    }

    /**
     * 复制文件
     *
     * @param source 输入文件
     * @param target 输出文件
     */
    public static void copy(File source, File target) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(source);
            fileOutputStream = new FileOutputStream(target);
            byte[] buffer = new byte[1024];
            while (fileInputStream.read(buffer) > 0) {
                fileOutputStream.write(buffer);
            }
        } catch (Exception e) {
            Log.e("TAG_PP","----->>"+e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                Log.e("TAG_PP","----->>1111"+e.getMessage());
                e.printStackTrace();
            }
        }
    }

}
