package com.wulias.project.tool;

import android.widget.Toast;

import com.wulias.project.base.App;

/**
 * 主要是打印信息 Log 和 Toask
 * Created by 曹小贼 on 2018/10/10.
 */

public class MsgTool {

    public static Toast mToast;
    /**
     * Toast
     * @param message
     */
    public static void showShortToast(String message) {
        if (mToast == null) {
            //只有mToast==null时才重新创建，否则只需更改提示文字
            mToast = Toast.makeText(App.getContext(), message, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(message);
        }
        mToast.show();

    }
}
