package com.wulias.project.ui.fragment;

import android.arch.lifecycle.Observer;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.CircularArray;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.wulias.project.R;
import com.wulias.project.bean.UserInfo;
import com.wulias.project.constacts.Constacts;
import com.wulias.project.presenter.TestPresenter;
import com.wulias.project.ui.adapter.DesignLoaderMoreAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.wulias.project.base.MVPFragment;
import com.wulias.project.presenter.CarPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 主界面之购物车
 * Created by Administrator on 2018/7/3.
 */

public class CarFragment extends MVPFragment<CarPresenter> implements OnRefreshLoadMoreListener {
    @BindView(R.id.status_title)
    View mVStatusTitle;
    @BindView(R.id.recycle)
    RecyclerView mRecycle;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private LinearLayoutManager layoutManager;

   private DesignLoaderMoreAdapter adapter;

    private CircularArray<UserInfo> circularArray = new CircularArray<>();


    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            List<String> list = new ArrayList<String>();
            list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1534395475339&di=682c14cbcf27a71b1b1085dd04ba5493&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fq_70%2Cc_zoom%2Cw_640%2Fimages%2F20180717%2Fe858d815168a41f6a1143d264fd7b983.jpeg");
            list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1534395521013&di=54bceadd265507a089169fad2155e72a&imgtype=0&src=http%3A%2F%2Fimg5q.duitang.com%2Fuploads%2Fitem%2F201502%2F27%2F20150227174402_i4JXw.jpeg");
            list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1534990258&di=b76f169e1da0663aa52204c3ce06efcd&imgtype=jpg&er=1&src=http%3A%2F%2Fattachments.gfan.com%2Fforum%2Fattachments2%2Fday_100928%2F100928140873c92fbddb02a8f4.jpg");
            list.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3166180384,1606540760&fm=27&gp=0.jpg");
            list.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2401266335,2589666593&fm=27&gp=0.jpg");
            for (String path:list){
                UserInfo userInfo = new UserInfo("123","123","123",path,123);
                circularArray.addLast(userInfo);
            }
            adapter.notifyDataSetChanged();
        }
    };
    @Override
    public int initLayout() {
        return R.layout.fragment_car;
    }

    @Override
    protected CarPresenter initPresenter() {
        return new CarPresenter();
    }

    @Override
    public void initView() {
        ViewGroup.LayoutParams params = mVStatusTitle.getLayoutParams();
        params.height = getStatusBarHeight();
        initRecycle();
    }
    @Override
    public void initData() {
    }


    public void initRecycle() {
        refresh.setOnRefreshListener(this);//刷新监听
        refresh.setOnLoadMoreListener(this);//加载监听
        layoutManager = new LinearLayoutManager(getContext());
        mRecycle.setLayoutManager(layoutManager);
        mRecycle.setHasFixedSize(true);
        adapter = new DesignLoaderMoreAdapter(getContext(),circularArray);
        mRecycle.setAdapter(adapter);
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        //加载
        refreshLayout.finishLoadMore(Constacts.REFRESHLOADMORE_TIME_OUT);//设置延迟时间
        handler.sendEmptyMessageAtTime(0,2000);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        //刷新
        refreshLayout.finishRefresh(Constacts.REFRESHLOADMORE_TIME_OUT);//设置延迟时间
        circularArray.clear();
        adapter.notifyDataSetChanged();

    }

}
