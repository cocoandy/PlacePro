package com.wulias.project.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wulias.project.R;
import com.wulias.project.base.RecycleAdapter;
import com.wulias.project.bean.CityBean;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/7/31.
 */

public class CityAdapter extends RecycleAdapter<CityAdapter.CityViewHolder> {

    private List<CityBean> mDatas;

    public CityAdapter(Context context, List<CityBean> mDatas) {
        super(context);
        this.mDatas = mDatas;
    }


    @Override
    public int getCount() {
        return mDatas.size();
    }

    @NonNull
    @Override
    public CityViewHolder onCreateHolder(@NonNull ViewGroup parent, int viewType) {
        return new CityViewHolder(getItemView(parent, R.layout.item_city));
    }

    @Override
    public void onBindViewData(CityViewHolder holder, int position) {
        CityBean bean = mDatas.get(position);
        holder.mTvName.setText(bean.getCityName());
    }

    class CityViewHolder extends RecycleAdapter.ViewHolder {

        @BindView(R.id.item_name)
        TextView mTvName;

        public CityViewHolder(View itemView) {
            super(itemView);

        }
    }
}
