package com.wulias.project.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.util.CircularArray;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.wulias.project.R;
import com.wulias.project.base.EmptyRecycle;
import com.wulias.project.bean.UserInfo;
import com.wulias.project.weight.GlideRoundTransform;

import butterknife.BindView;

/**
 * Created by sunwei on 2015/12/4.
 * Email: lx_sunwei@163.com.
 * Description: 滑动到底部加载更多
 */
public class DesignLoaderMoreAdapter extends EmptyRecycle<EmptyRecycle.ViewHolder> {

    private CircularArray<UserInfo> mDesignItems;
    private Context context;

    public DesignLoaderMoreAdapter(Context context, CircularArray<UserInfo> datas) {
        super(context);
        this.mDesignItems = datas;
        this.context = context;
    }

    @Override
    public int getCount() {

        return mDesignItems.size();
    }

    @Override
    public void onBindViewData(EmptyRecycle.ViewHolder holder, int position) {
        DesignViewHolder viewHolder = (DesignViewHolder) holder;
        UserInfo designItem = mDesignItems.get(position);
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.amin_loadding)// 正在加载中的图片
                .error(R.mipmap.ic_launcher) // 加载失败的图片
                .transform(new GlideRoundTransform(context, 10))
                .diskCacheStrategy(DiskCacheStrategy.ALL); // 磁盘缓存策略
        Glide.with(context)
                .load(designItem.getCover())
                .apply(options)
                .into(viewHolder.logo);
    }

    @Override
    public EmptyRecycle.ViewHolder onCreateHolder(@NonNull ViewGroup parent, int viewType) {
        return new DesignViewHolder(getItemView(parent, R.layout.list_item_test, false));
    }

    @Override
    public EmptyRecycle.ViewHolder getEmptyHolder(ViewGroup parent) {
        return new ViewHolder(getItemView(parent, R.layout.layout_empty, false));
    }


    //正常条目
    public class DesignViewHolder extends EmptyRecycle.ViewHolder {
        @BindView(R.id.logo)
        public ImageView logo;
        public TextView textView;
        public CardView cardView;

        public DesignViewHolder(View view) {
            super(view);
        }
    }


}
