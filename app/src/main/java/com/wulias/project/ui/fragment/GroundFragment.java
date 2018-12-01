package com.wulias.project.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wulias.project.R;
import com.wulias.project.base.MVPFragment;
import com.wulias.project.bean.entity.GroundBean;
import com.wulias.project.constacts.Constacts;
import com.wulias.project.presenter.GroundPresenter;
import com.wulias.project.util.UI;
import com.wulias.project.ui.activity.SearchActivity;
import com.wulias.project.ui.adapter.GroundAdapter;
import com.wulias.project.weight.FoldPop;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 主界面之场地
 * Created by Administrator on 2018/7/3.
 */

public class GroundFragment extends MVPFragment<GroundPresenter> {

    @BindView(R.id.ground_recycle)
    RecyclerView mRvGround;

    @BindView(R.id.text_ground_men_normal)
    TextView mTvNormal;
    @BindView(R.id.text_ground_men_area)
    TextView mTvArea;
    @BindView(R.id.text_ground_men_price)
    TextView mTvPrice;
    @BindView(R.id.text_ground_men_filter)
    TextView mTvFilter;
    @BindView(R.id.ll_menu)
    LinearLayout mLlMenu;
    @BindView(R.id.main)
    LinearLayout mLlMain;
    @BindView(R.id.view_statusbar)
    View mViewStatus;
    @BindView(R.id.tv_ground_scaner)
    TextView mTvScaner;

    private List<GroundBean> mDatas = new ArrayList<>();

    private GroundAdapter adapter;
    private FoldPop foldPop;

    @Override
    public void initView() {
        showStatusBar(mViewStatus);
        setMenuIcon(mTvNormal, R.mipmap.ic_bottom_normal);
        setMenuIcon(mTvArea, R.mipmap.ic_bottom_normal);
        setMenuIcon(mTvPrice, R.mipmap.ic_price_normal);
        setMenuIcon(mTvFilter, R.mipmap.ic_filter_normal);
        foldPop = new FoldPop(mContext, UI.getScreenWidth(), UI.getScreenHeight(), new FoldPop.IPopuWindowListener() {
            @Override
            public void dispose() {

            }
        });
    }


    public void setMenuIcon(TextView textView, int res) {
        Resources resources = getResources();
        Drawable myImage = resources.getDrawable(res);
        myImage.setBounds(1, 1, 20, 20);
        textView.setCompoundDrawables(null, null, myImage, null);
        textView.setCompoundDrawablePadding(8);
    }

    @Override
    public void initData() {
        initRecycle();
    }

    @Override
    public int initLayout() {
        return R.layout.fragment_ground;
    }

    @Override
    protected GroundPresenter initPresenter() {
        return new GroundPresenter();
    }

    @OnClick({R.id.text_ground_men_filter, R.id.tv_ground_scaner})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text_ground_men_filter:
                foldPop.show(mLlMenu);
                break;
            case R.id.tv_ground_scaner:
                Intent intent = new Intent();
                intent.setClass(mContext, SearchActivity.class);
                intent.putExtra(Constacts.INTENT.KEY_PAGE_TYPE,2);
                startActivityForResult(intent, Activity.RESULT_FIRST_USER);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Constacts.RESULTCODE.CODE_SEARCH_VALUE && data != null) {
            mTvScaner.setText(data.getStringExtra(Constacts.INTENT.KEY_SEARCH_VALUE));
        }

    }

    private void initRecycle() {

        List<String> list = new ArrayList<String>();
        list.add("https://img.linhuiba.com/Fj9KtvkOpNVfeOC-YWM4dw6C60na-linhuiba_half?v=1");
        list.add("https://img.linhuiba.com/FqZ671QjgD3zGsgHci1DWWK-4xkx-linhuiba_half?v=1");
        list.add("https://img.linhuiba.com/FvcuWOfG-1AlfW8corM1hCtXIKTl-linhuiba_half?v=1");
        list.add("https://img.linhuiba.com/o_1bgr4gajc1l4u1sqtsvv145pcalc.jpg-linhuiba_half?v=1");
        list.add("https://img.linhuiba.com/o_1bgr0i0q618v6137o1a1h18fm1oa0f.jpg-linhuiba_half?v=1");

        mDatas.add(new GroundBean("深圳市罗湖老街", list.get(0)));
        mDatas.add(new GroundBean("深圳市南山城区科技园", list.get(4)));
        mDatas.add(new GroundBean("深圳市南山城区科技园", list.get(3)));
        mDatas.add(new GroundBean("深圳市罗湖老街", list.get(0)));
        mDatas.add(new GroundBean("深圳市南山城区科技园", list.get(1)));
        mDatas.add(new GroundBean("深圳市宝安区那个啥", list.get(2)));
        mDatas.add(new GroundBean("深圳市罗湖老街", list.get(3)));
        mDatas.add(new GroundBean("深圳市罗湖老街", list.get(2)));
        mDatas.add(new GroundBean("深圳市南山城区科技园", list.get(1)));
        mDatas.add(new GroundBean("深圳市罗湖老街", list.get(0)));
        mDatas.add(new GroundBean("深圳市南山城区科技园", list.get(3)));
        adapter = new GroundAdapter(mContext, mDatas);
        mRvGround.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
        mRvGround.setLayoutManager(new LinearLayoutManager(mContext));
        mRvGround.setAdapter(adapter);
    }


}
