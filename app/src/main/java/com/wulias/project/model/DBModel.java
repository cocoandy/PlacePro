package com.wulias.project.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.wulias.project.bean.UserBean;
import com.wulias.project.tool.Tool;

/**
 * SQLite管理类 数据持久化
 *
 * Created by 曹小贼 on 2018/10/26.
 * https://blog.csdn.net/liuhe688/article/details/6715983
 */

public class DBModel {

    private SQLiteDatabase database;
    private final static String TABLE_USER = "_user.db";
    private final static String TABLE_USER_NAME = "_user";

    private final static String SQL_CREATE_USER =
            "CREATE TABLE person (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "userName VARCHAR, " +
                    "nickName VARCHAR, " +
                    "token VARCHAR)";


    public DBModel(Context mContext) {
        SQLiteDatabase database = mContext.openOrCreateDatabase(TABLE_USER, Context.MODE_PRIVATE, null);
    }

    /**
     * 创建数据表
     */
    public void initDB() {
        database.execSQL(SQL_CREATE_USER);
        database.close();
    }

    public void saveUser(UserBean user) {
        ContentValues values = Tool.toContentValues(user);
        database.insert(TABLE_USER_NAME,null,values);
        database.close();
    }


    public UserBean getUser() {
        return null;
    }

}
