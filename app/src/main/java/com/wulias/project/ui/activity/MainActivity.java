package com.wulias.project.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.wulias.navigation.widget.NavigationBar;
import com.wulias.project.R;
import com.wulias.project.base.MVPActivity;
import com.wulias.project.bean.UserInfo;
import com.wulias.project.presenter.TestPresenter;
import com.wulias.project.tool.MsgTool;
import com.wulias.project.tool.Tool;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import butterknife.BindView;
import butterknife.internal.Utils;

public class MainActivity extends MVPActivity<TestPresenter> {
    @BindView(R.id.selft_bottom_menu)
    NavigationBar mBmMenu;
    List<Fragment> mList;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void initView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //4.4以后此方法设置状态栏透明
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        presenter.initNavigation(getSupportFragmentManager(), mBmMenu);
        if (!Tool.isNotificationEnabled()) {
            goToSet();
        } else {
            MsgTool.showShortToast("已经开启通知");
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                inquireTrainTickets();
            }
        }).start();
    }

    private void goToSet() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.BASE) {
            // 进入设置系统应用权限界面
            Intent intent = new Intent(Settings.ACTION_SETTINGS);
            startActivity(intent);
            return;
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {// 运行系统在5.x环境使用
            // 进入设置系统应用权限界面
            Intent intent = new Intent(Settings.ACTION_SETTINGS);
            startActivity(intent);
            return;
        }
    }

    @Override
    public void initData() {
//        showProgress();
//        presenter.loadingAll();
    }

    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected TestPresenter initPresenter() {
        return new TestPresenter();
    }

    private final String API_KEY = "d8defbac95624cfe819fe3e565c2073b";
    private final String HTTP_URL = "http://route.showapi.com/909-1";
    private final String HTTP_ARG = "showapi_appid=77162&from=START&to=END&trainDate=YEAR-MOUTH-DAY";

    private void inquireTrainTickets() {
        Log.i("2------", "jinru");
        String httpUrl;
        String httpArg =
                HTTP_ARG.
                        replace("START", "梧州南")
                        .replace("END", "南宁")
                        .replace("YEAR", "" + 2018)
                        .replace("MOUTH", "" + 10)
                        .replace("DAY", "26");

//            Utils.showLog(httpArg);
//        Log.i("3------", httpArg);
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = HTTP_URL + "?showapi_sign=" + API_KEY + "&" + httpArg;
        Log.i("4------", httpUrl);
        try {
            URL url = new URL(httpUrl);
            Log.i("2222------", url.toString());
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("POST");
            //connection.setRequestProperty("apikey",  API_KEY);
            connection.connect();
            InputStream is = connection.getInputStream();
            Log.i("6------", is.toString());
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                Log.i("7------", strRead);
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("5------", result);
//            setTrainTicketList(result);
    }
}
