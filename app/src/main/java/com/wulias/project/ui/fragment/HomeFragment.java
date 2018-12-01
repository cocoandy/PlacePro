package com.wulias.project.ui.fragment;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.wulias.project.R;
import com.wulias.project.base.MVPFragment;
import com.wulias.project.bean.entity.HomeBean;
import com.wulias.project.presenter.HomePresenter;
import com.wulias.project.util.BannerImageLoader;
import com.wulias.project.ui.activity.GroundDetailActivity;
import com.wulias.project.ui.activity.SearchActivity;
import com.wulias.project.ui.adapter.HomeAdapter;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 主界面之首页
 * Created by Administrator on 2018/7/3.
 */

public class HomeFragment extends MVPFragment<HomePresenter> {
    @BindView(R.id.home_title_city)
    TextView mTvCity;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.home_recycle)
    RecyclerView mRecycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout mSrRefresh;
    @BindView(R.id.home_banner)
    Banner banner;

    private HomeAdapter adapter;

    private List<HomeBean> mDatas = new ArrayList<>();

    @Nullable
    @Override
    public int initLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    public void initView() {
//        mSrRefresh.setOnRefreshListener(this);
//        mSrRefresh.setEnableLoadMore(false);
    }

    @Override
    public void initData() {
        List<String> list = new ArrayList<String>();
        list.add("https://img.linhuiba.com/Fj9KtvkOpNVfeOC-YWM4dw6C60na-linhuiba_half?v=1");
        list.add("https://img.linhuiba.com/FqZ671QjgD3zGsgHci1DWWK-4xkx-linhuiba_half?v=1");
        list.add("https://img.linhuiba.com/FvcuWOfG-1AlfW8corM1hCtXIKTl-linhuiba_half?v=1");
        list.add("https://img.linhuiba.com/o_1bgr4gajc1l4u1sqtsvv145pcalc.jpg-linhuiba_half?v=1");
        list.add("https://img.linhuiba.com/o_1bgr0i0q618v6137o1a1h18fm1oa0f.jpg-linhuiba_half?v=1");

        HomeBean<String> bean = new HomeBean<>();
        bean.setTitle("12");
        bean.setType(0);
        bean.setList(list);
//        mDatas.add(bean);
        for (int i = 0; i < 23; i++) {
            HomeBean<String> info = new HomeBean<>();
            if (i % 5 == 0) {
                info.setTitle("大家都在订" + i);
                info.setType(2);
            } else {
                info.setTitle("深圳市龙华新区深圳北站神马广场");
                info.setType(1);
                info.setPrice(i * 10 + i);
                info.setCover(list.get(i % 5));
            }
            mDatas.add(info);
        }

        sortData();

        List<String> bunnerList = new ArrayList<String>();
        bunnerList.add("https://img.linhuiba.com/FllPpDjhGOS6MXxsfQNy526hi-pw-linhuiba_half?v=1");
        bunnerList.add("https://img.linhuiba.com/Fsbkjy7DCLM5Kb6ONMIAqRmaUzHO-linhuiba_half?v=1");
        bunnerList.add("https://img.linhuiba.com/Fk4smZ7fOT1tFEm3Vm7Q5BmxSgvk-linhuiba_half?v=1");
        bunnerList.add("https://img.linhuiba.com/FpAlOP6Wt_BIhszSMDlETbe_b9E--linhuiba_half?v=1");
        bunnerList.add("https://img.linhuiba.com/Fj_MGuCLFg7nOKNtESBk2Zr7pOi6-linhuiba_half?v=1");
        banner.setImageLoader(new BannerImageLoader());
        //设置图片集合
        banner.setImages(bunnerList);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        initRecycle();
    }

    /**
     * 设置下标（主要是用于设置网格的间隔等分问题）
     */
    public void sortData() {
        int position = 0;
        for (int i = 0, len = mDatas.size(); i < len; i++) {
            HomeBean bean = mDatas.get(i);
            if (bean.getType() == 2) {
                position = i;
            } else if (bean.getType() == 1) {
                mDatas.get(i).setIndex(i - position - 1);
            }
        }
    }


    @OnClick({R.id.home_title_city, R.id.home_scaner})
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.home_title_city:
                intent = new Intent();
                intent.setClass(mContext, GroundDetailActivity.class);
                startActivity(intent);
                break;
            case R.id.home_scaner:
                intent = new Intent();
                intent.setClass(mContext, SearchActivity.class);
                startActivity(intent);
                break;
        }
    }

    GridLayoutManager gridLayoutManager;

    private void initRecycle() {
        adapter = new HomeAdapter(mContext, mDatas);
        gridLayoutManager = new GridLayoutManager(mContext, 2);
        mRecycle.setLayoutManager(gridLayoutManager);
        mRecycle.setAdapter(adapter);
    }
}
