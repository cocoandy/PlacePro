package com.wulias.project.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.wulias.project.R;
import com.wulias.project.base.BaseBean;
import com.wulias.project.base.RecycleAdapter;

import java.util.List;

/**
 * Created by 曹小贼 on 2018/10/22.
 */

public class GroundDetailAdapter extends RecycleAdapter {

    List<BaseBean> mData;

    public GroundDetailAdapter(Context context, List<BaseBean> mData) {
        super(context);
        this.mData = mData;
    }

    @Override
    public void onBindViewData(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            GroundHeadHolde headHolde = (GroundHeadHolde) holder;
        } else {
            GroundDetailHolde detailHolde = (GroundDetailHolde) holder;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new GroundHeadHolde(getItemView(parent, R.layout.item_ground_detail_banner));
        } else {
            return new GroundDetailHolde(getItemView(parent, R.layout.item_ground_detail));
        }
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    public class GroundDetailHolde extends RecycleAdapter.ViewHolder {

        public GroundDetailHolde(View itemView) {
            super(itemView);
        }
    }

    public class GroundHeadHolde extends RecycleAdapter.ViewHolder {

        public GroundHeadHolde(View itemView) {
            super(itemView);
        }
    }
}
