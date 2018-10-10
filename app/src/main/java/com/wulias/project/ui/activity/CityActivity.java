package com.wulias.project.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;

import com.wulias.project.R;
import com.wulias.project.base.MVPActivity;
import com.wulias.project.presenter.CityPresenter;
import com.wulias.project.ui.adapter.CityAdapter;
import com.wulias.project.weight.LetterNavigationView;
import com.wulias.project.weight.FloatingItemDecoration;

import java.util.Map;

import butterknife.BindView;

/**
 * 城市选择界面
 * <p>
 * 2018/7/25 by 曹小贼
 */
public class CityActivity extends MVPActivity<CityPresenter> implements LetterNavigationView.OnTouchListener {

    @BindView(R.id.ln_menu_right)
    LetterNavigationView mLnMenu;
    @BindView(R.id.recycle)
    RecyclerView mRvCity;

    private CityAdapter adapter;
    private FloatingItemDecoration itemDecoration;
    private LinearLayoutManager layoutManager;

    @Override
    public int initLayout() {
        return R.layout.activity_city;
    }

    @Override
    public void initView() {
        mLnMenu.setOnTouchListener(this);
        initRecycle();
    }

    @Override
    public void initData() {
        presenter.getDatas();
        mLnMenu.setData(presenter.mLetterDatas);
        itemDecoration.setKeys(presenter.mTitles);
    }

    @Override
    protected CityPresenter initPresener() {
        return new CityPresenter();
    }

    @Override
    public void onTouchListener(String str, boolean hideEnable) {
        int position = 0;
        for (Map.Entry<Integer, String> entry : presenter.mTitles.entrySet()) {
            if (entry.getValue().equals(str)) {
                position = entry.getKey();
            }
        }
        presenter.MoveToPosition(layoutManager, position);

    }



    public void initRecycle() {
        itemDecoration = new FloatingItemDecoration(mContext);
        itemDecoration.setmTitleHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 35, getResources().getDisplayMetrics()));
        itemDecoration.setBackColor(R.color.bottom_textcolor);
        adapter = new CityAdapter(this, presenter.mDatas);
        layoutManager = new LinearLayoutManager(this);
        mRvCity.setLayoutManager(layoutManager);
        mRvCity.addItemDecoration(itemDecoration);
        mRvCity.setAdapter(adapter);
        mRvCity.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (layoutManager instanceof LinearLayoutManager) {
                    //获取可见的第一个Item
                    int firstItemPosition = layoutManager.findFirstVisibleItemPosition();
                    //拿到首字母
                    String value = presenter.mDatas.get(firstItemPosition).getFirstPinYin();

                    if (value != null) {
                        //拿到首字母在右侧导航中的第几项
                        int position = presenter.getLetterDataIndex(value);
                        if (position != mLnMenu.getSelectorPosition()) {
                            //根据拿到的角标移动右侧导航的选择Item
                            mLnMenu.changeSelectItem(position);
                        }
                    }
                }
            }
        });
    }

}
