package com.wulias.project.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.wulias.project.R;
import com.wulias.project.base.MVPFragment;
import com.wulias.project.bean.SelfBean;
import com.wulias.project.presenter.SelfPresenter;
import com.wulias.project.presenter.TestPresenter;
import com.wulias.project.tool.Tool;
import com.wulias.project.ui.activity.LoginActivity;
import com.wulias.project.ui.adapter.SelfAdapter;
import com.wulias.project.weight.SpacesItemDecoration;
import com.wulias.project.tool.UI;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 主界面之我的
 * Created by Administrator on 2018/7/3.
 */

public class SelfFragment extends MVPFragment<SelfPresenter> {
    @BindView(R.id.self_recycle)
    RecyclerView mRvSelf;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.img_self_setting)
    ImageView mImgSetting;

    private SelfAdapter adapter;
    private List<SelfBean> mData;

    @Override
    public int initLayout() {
        return R.layout.fragment_self;
    }

    @Override
    protected SelfPresenter initPresenter() {
        return new SelfPresenter();
    }


    @Override
    public void initView() {
        initRecycle();
    }

    private void initRecycle() {
        mData = new ArrayList<>();
        adapter = new SelfAdapter(mContext, mData);
        mRvSelf.setLayoutManager(new GridLayoutManager(mContext, 4));
        mRvSelf.addItemDecoration(new SpacesItemDecoration() {
            @Override
            public Decoration getItemOffsets(int position) {
                ColorDecoration decoration = new ColorDecoration();
                //你的逻辑设置分割线
                decoration.bottom = 1;  //下分割
                decoration.decorationColor = getResources().getColor(R.color.split_line); //分割线颜色
                return decoration;
            }
        });
        mRvSelf.setAdapter(adapter);
        mRvSelf.addOnScrollListener(new RecyclerView.OnScrollListener() {

            private int totalScroll = 0;
            private float limitY = UI.dp2Px(70);
            private float totleY = UI.dp2Px(67);

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalScroll = totalScroll + dy;

                if (totalScroll < UI.dp2Px(12)) {
                    toolbar.setBackgroundColor(Color.TRANSPARENT);
                } else if (totalScroll < UI.dp2Px(24)) {
                    toolbar.setBackgroundColor(UI.changeAlpha(getResources().getColor(R.color.white), 0.2F));
                } else if (totalScroll < UI.dp2Px(36)) {
                    toolbar.setBackgroundColor(UI.changeAlpha(getResources().getColor(R.color.white), 0.4F));
                } else if (totalScroll < UI.dp2Px(48)) {
                    toolbar.setBackgroundColor(UI.changeAlpha(getResources().getColor(R.color.white), 0.6F));
                } else if (totalScroll < UI.dp2Px(60)) {
                    toolbar.setBackgroundColor(UI.changeAlpha(getResources().getColor(R.color.white), 8.0F));
                } else if (totalScroll > UI.dp2Px(70)) {
                    toolbar.setBackgroundColor(Color.WHITE);
                }
            }
        });
    }

    @OnClick({R.id.img_self_setting})
    public void onClick(View view) {
        startActivity(new Intent(mContext, LoginActivity.class));
    }

    @Override
    public void initData() {
        mData.add(new SelfBean("", 0, 0));
        mData.add(new SelfBean("我的订单", "查看全部订单", R.mipmap.right, 3));
        mData.add(new SelfBean("", 0, 1));
        mData.add(new SelfBean("常用工具", R.mipmap.right, 3));
        mData.add(new SelfBean("我的定制", R.mipmap.ic_custom, 2));
        mData.add(new SelfBean("我的积分", R.mipmap.ic_integral, 2));
        mData.add(new SelfBean("我的票据", R.mipmap.ic_tickey, 2));
        mData.add(new SelfBean("我的关注", R.mipmap.ic_attention, 2));
        mData.add(new SelfBean("切换到物业，发布场地", R.mipmap.right, 3));
        mData.add(new SelfBean("版本更新", R.mipmap.right, 3));
        mData.add(new SelfBean("联系客服", R.mipmap.right, 4));
        mData.add(new SelfBean("广告预订", R.mipmap.right, 4));
        mData.add(new SelfBean("我的钱包", R.mipmap.right, 4));
        adapter.notifyDataSetChanged();
    }


}
