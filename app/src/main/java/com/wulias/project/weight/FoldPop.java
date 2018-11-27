package com.wulias.project.weight;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.wulias.project.R;
import com.wulias.project.bean.entity.GroundBean;
import com.wulias.project.ui.adapter.FoldAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 曹小贼 on 2018/11/2.
 */

public class FoldPop extends PopupWindow {

    private RelativeLayout mLlMain;

    private Context mContext;//上下文
    private IPopuWindowListener mOnClickListener;// PopupWindow中控件点击事件回调接口

    private Button mBtnSure;
    private Button mBtnReset;
    private RecyclerView mRvFoldMenu;
    private FoldAdapter adapter;
    private List<GroundBean> mDatas;

    /**
     * @param
     * @description 构造方法
     * @author ldm
     * @time 2016/9/30 9:14
     */
    public FoldPop(Context mContext, int width, int height, IPopuWindowListener listener) {
        super(mContext);
        this.mContext = mContext;
        this.mOnClickListener = listener;
        //获取布局文件
        View mContentView = LayoutInflater.from(mContext).inflate(R.layout.pop_fold_menu, null);
        mLlMain = (RelativeLayout)mContentView.findViewById(R.id.main);
        ViewGroup.LayoutParams layoutParams = mLlMain.getLayoutParams();
        layoutParams.height = height * 4 / 7;
        //设置布局
        setContentView(mContentView);
        // 设置弹窗的宽度和高度
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        //设置能否获取到焦点
        setFocusable(false);
        //设置PopupWindow进入和退出时的动画效果
//        setAnimationStyle(R.style.popwindow_exit_anim_style);
        setTouchable(true); // 默认是true，设置为false，所有touch事件无响应，而被PopupWindow覆盖的Activity部分会响应点击
        // 设置弹窗外可点击,此时点击PopupWindow外的范围，Popupwindow不会消失
        setOutsideTouchable(true);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xa0000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
        // 设置弹窗的布局界面
        initUI(mContext);
    }

    /**
     * 初始化弹窗列表
     */
    private void initUI(Context mContext) {
        //获取到按钮
        mBtnSure = getContentView().findViewById(R.id.btn_sure);
        mBtnReset = getContentView().findViewById(R.id.btn_reset);
        mRvFoldMenu = getContentView().findViewById(R.id.recycle);
        mDatas = new ArrayList<>();
        adapter = new FoldAdapter(mContext,mDatas);
        mRvFoldMenu.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
        mRvFoldMenu.setLayoutManager(new LinearLayoutManager(mContext));
        mRvFoldMenu.setAdapter(adapter);
    }

    /**
     * 显示弹窗列表界面
     */
    @SuppressLint("NewApi")
    public void show(View view) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        //Gravity.BOTTOM设置在view下方，还可以根据location来设置PopupWindowj显示的位置
        showAsDropDown(view, 0, 0, Gravity.NO_GRAVITY);
    }

    /**
     * @param
     * @author ldm
     * @description 点击事件回调处理接口
     * @time 2016/7/29 15:30
     */
    public interface IPopuWindowListener {
        void dispose();
    }
}
