package com.wulias.project.tool;

import android.content.Context;
import android.content.SharedPreferences;

import com.wulias.project.base.App;

/**
 * SharedPreferences
 * Created by 曹小贼 on 2018/10/9.
 */

public class SPTool {
    /**
     * 得到上下文
     */
    public static Context getContext() {
        return App.getContext();
    }

    public static SharedPreferences.Editor save(String tableName) {
        SharedPreferences sp = getContext().getSharedPreferences(tableName, Context.MODE_PRIVATE);
        return sp.edit();
    }
    public static SharedPreferences getData(String tableName){
            SharedPreferences sp = getContext().getSharedPreferences(tableName, Context.MODE_PRIVATE);
            return sp;
    }
}
