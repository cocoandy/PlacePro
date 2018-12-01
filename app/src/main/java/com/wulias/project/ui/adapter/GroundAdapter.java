package com.wulias.project.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wulias.project.R;
import com.wulias.project.base.RecycleAdapter;
import com.wulias.project.bean.entity.GroundBean;
import com.wulias.project.util.ImagLoad;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * 订场地主界面 场地列表
 * Created by Administrator on 2018/8/9.
 */

public class GroundAdapter extends RecycleAdapter<GroundAdapter.GroundHolder> {

    List<GroundBean> mDatas;
    Map<String, Boolean> map;

    public GroundAdapter(Context context, List<GroundBean> mDatas) {
        super(context);
        this.mDatas = mDatas;
        map = new HashMap<>();
    }

    @NonNull
    @Override
    public GroundHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GroundHolder(getItemView(parent, R.layout.item_ground));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public void onBindViewData(GroundHolder holder, int position) {
        final GroundBean bean = mDatas.get(position);
        holder.mTvName.setText(bean.getName());
        ImagLoad.install().with(context).load(bean.getTitle()).into(holder.mImgCover);
    }

    @Override
    public GroundHolder onCreateHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }


    public static class GroundHolder extends RecycleAdapter.ViewHolder {
        @BindView(R.id.item_ground_cover)
        ImageView mImgCover;
        @BindView(R.id.item_ground_name)
        TextView mTvName;
        @BindView(R.id.item_ground_peoples)
        TextView mTvPeoples;
        @BindView(R.id.item_ground_orders)
        TextView mTvOrders;
        @BindView(R.id.item_ground_address)
        TextView mTvAddress;
        @BindView(R.id.item_ground_status)
        TextView mTvStatus;
        @BindView(R.id.item_ground_price)
        TextView mTvPrice;
        @BindView(R.id.item_ground_price_msg)
        TextView mTvPriceMsg;

        public GroundHolder(View itemView) {
            super(itemView);
        }

        public void setVisibility(boolean isGone) {
            RecyclerView.LayoutParams param = (RecyclerView.LayoutParams) itemView.getLayoutParams();
            if (isGone) {
                param.height = 0;
                param.width = 0;
            } else {
                param.height = LinearLayout.LayoutParams.WRAP_CONTENT;
                param.width = LinearLayout.LayoutParams.MATCH_PARENT;
            }
            itemView.setLayoutParams(param);
        }
    }

}
