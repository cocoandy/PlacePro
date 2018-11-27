package com.wulias.project.tool;

import android.content.Context;
import android.content.SharedPreferences;

import com.wulias.project.base.App;
import com.wulias.project.constacts.Constacts;

/**
 * SharedPreferences
 * Created by 曹小贼 on 2018/10/9.
 */

public class SPTool {


    private Context mContext;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    public SPTool(Context mContext) {
        this.mContext = mContext;
        mPreferences = mContext.getSharedPreferences(Constacts.SPKey.TABLE_NAME_MAIN, Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();
    }

    /**
     * 删除Key值,返回boolean是否执行成功！
     */
    public boolean removeKey(String key) {

        return mEditor.remove(key).commit();
    }

    /**
     * 提交操作
     */
    public void commit() {
        mEditor.commit();
    }

    /**
     * @param key
     * @param value
     */
    public void putString(String key, String value) {
        if (key != null) {
            mEditor.putString(key, value);
        }
    }

    /**
     * @param key
     * @param value
     */
    public void putBoolean(String key, boolean value) {
        if (key != null) {
            mEditor.putBoolean(key, value);
        }
    }

    /**
     * @param key
     * @param value
     */
    public void putInt(String key, int value) {
        if (key != null) {
            mEditor.putInt(key, value);
        }
    }

    /**
     * @param key
     * @param value
     */
    public void putLong(String key, long value) {
        if (key != null) {
            mEditor.putLong(key, value);
        }
    }

    /**
     * @param key
     * @param value
     */
    public void putFloat(String key, float value) {
        if (key != null) {
            mEditor.putFloat(key, value);
        }
    }


    /**
     * @param key
     */
    public String getString(String key) {
        return mPreferences.getString(key, null);
    }

    /**
     * @param key
     */
    public int getInt(String key) {
        return mPreferences.getInt(key, 0);
    }

    /**
     * @param key
     */
    public boolean getBoolean(String key) {
        return mPreferences.getBoolean(key, false);
    }

    /**
     * @param key
     */
    public float getFloat(String key) {
        return mPreferences.getFloat(key, 0F);
    }

    /**
     * @param key
     */
    public long getLong(String key) {
        return mPreferences.getLong(key, 0L);
    }
}
