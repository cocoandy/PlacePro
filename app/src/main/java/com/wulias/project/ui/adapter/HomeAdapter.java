package com.wulias.project.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wulias.project.R;
import com.wulias.project.base.EmptyRecycle;
import com.wulias.project.bean.entity.HomeBean;
import com.wulias.project.tool.BannerImageLoader;
import com.wulias.project.tool.ImagLoad;
import com.wulias.project.tool.UI;
import com.youth.banner.Banner;

import java.util.List;

import butterknife.BindView;

/**
 * 首页主数据适配器
 * Created by 曹小贼 on 2018/8/15.
 */

public class HomeAdapter extends EmptyRecycle {
    private List<HomeBean> mDatas;

    public HomeAdapter(Context context, List<HomeBean> mDatas) {
        super(context);
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public void onBindViewData(RecyclerView.ViewHolder holder, int position) {
        HomeBean bean = mDatas.get(position);
        if (holder instanceof BannerHolder) {//轮播图
            BannerHolder bannerHolder = (BannerHolder) holder;
            List<String> list = bean.getList();
            bannerHolder.starBanner(list);
        } else if (holder instanceof MainHolder) {//主数据
            MainHolder mainHolder = (MainHolder) holder;

            mainHolder.mTvName.setText(bean.getTitle());
            mainHolder.mTvPrice.setText("￥" + bean.getPrice());
            ImagLoad.install().with(context).load(bean.getCover()).apply(640, 480, null).into(mainHolder.mImgCover);
            mainHolder.setMargins(position);

        } else {
            TitleHolder titleHolder = (TitleHolder) holder;
            titleHolder.mTvTitle.setText(bean.getTitle());
            if (position == 0) {
                titleHolder.mLine.setVisibility(View.INVISIBLE);
            } else {
                titleHolder.mLine.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public EmptyRecycle.ViewHolder onCreateHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new BannerHolder(getItemView(parent, R.layout.item_home_banner));
        } else if (viewType == 1) {
            return new MainHolder(getItemView(parent, R.layout.item_home_main));
        }
        return new TitleHolder(getItemView(parent, R.layout.item_home_title));
    }

    @Override
    public EmptyRecycle.ViewHolder getEmptyHolder(ViewGroup parent) {
        return new ViewHolder(getItemView(parent, R.layout.layout_empty, false));
    }


    @Override
    public int getItemSpanSize(GridLayoutManager manager, int position) {
        if (mDatas.get(position).getType() == 1) {
            return 1;
        }
        return 2;
    }


    @Override
    public int getItemType(int position) {
       return mDatas.get(position).getType();
    }


    /**
     * 轮播图View管理
     */
    public class BannerHolder extends EmptyRecycle.ViewHolder {
        @BindView(R.id.home_banner)
        Banner banner;

        public BannerHolder(View itemView) {
            super(itemView);
        }

        public void starBanner(List<String> imgPath) {
            banner.setImageLoader(new BannerImageLoader());
            //设置图片集合
            banner.setImages(imgPath);
            //banner设置方法全部调用完毕时最后调用
            banner.start();
        }
    }

    /**
     * View管理
     */
    public class MainHolder extends EmptyRecycle.ViewHolder {
        @BindView(R.id.item_home_cover)
        ImageView mImgCover;
        @BindView(R.id.item_home_name)
        TextView mTvName;
        @BindView(R.id.item_home_price)
        TextView mTvPrice;
        @BindView(R.id.item_home_msg)
        LinearLayout mLlMsg;

        public MainHolder(View itemView) {
            super(itemView);

            int itemWith = (UI.getScreenWidth() - UI.dp2Px(48)) / 2;

            ViewGroup.LayoutParams paramsIMG = mImgCover.getLayoutParams();
            paramsIMG.height = itemWith * 3 / 4;
            paramsIMG.width = itemWith;

            ViewGroup.LayoutParams paramsLL = mLlMsg.getLayoutParams();
            paramsLL.width = itemWith;
        }

        public void setMargins(int position) {
            if (mDatas.get(position).getIndex() % 2 == 0) {
                itemView.setPadding(UI.dp2Px( 16), 0, 0, UI.dp2Px( 8));
            } else {
                itemView.setPadding(UI.dp2Px( 8), 0, 0, UI.dp2Px( 8));
            }
        }
    }

    /**
     * View管理
     */
    public class TitleHolder extends EmptyRecycle.ViewHolder {
        @BindView(R.id.item_home_title)
        TextView mTvTitle;
        @BindView(R.id.item_home_title_line)
        View mLine;

        public TitleHolder(View itemView) {
            super(itemView);
        }
    }
}
