package com.wulias.project.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wulias.project.R;
import com.wulias.project.base.RecycleAdapter;
import com.wulias.project.bean.entity.GroundBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * 折叠列表适配器
 * Created by Administrator on 2018/8/9.
 */

public class FoldAdapter extends RecycleAdapter<FoldAdapter.GroundHolder> {

    List<GroundBean> mDatas;
    Map<String, Boolean> map;

    public FoldAdapter(Context context, List<GroundBean> mDatas) {
        super(context);
        this.mDatas = mDatas;
        map = new HashMap<>();
    }

    @NonNull
    @Override
    public GroundHolder onCreateHolder(@NonNull ViewGroup parent, int viewType) {
        return new GroundHolder(getItemView(parent, R.layout.item_fold));
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public void onBindViewData(GroundHolder holder, int position) {
        final GroundBean bean = mDatas.get(position);
        boolean isGone = map.get(bean.getTitle()) == null ? true : map.get(bean.getTitle());
        holder.itemName.setText(bean.getName());

        if (!"".equals(bean.getTitle())) {
            holder.setVisibility(isGone);
            holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.white));
        } else {
            holder.setVisibility(false);
            holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("".equals(bean.getTitle())) {
                    boolean isSelect = map.get(bean.getName()) == null ? true : map.get(bean.getName());
                    map.put(bean.getName(), !isSelect);
                    notifyDataSetChanged();
                }

            }
        });
    }


    @Override
    public int getItemSpanSize(GridLayoutManager manager, int position) {
        if (!"".equals(mDatas.get(position).getTitle())) {
            return 1;
        } else {
            return 3;
        }
    }

    public class GroundHolder extends RecycleAdapter.ViewHolder {

        @BindView(R.id.item_name)
        TextView itemName;

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
