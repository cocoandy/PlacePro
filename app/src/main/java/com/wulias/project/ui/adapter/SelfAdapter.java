package com.wulias.project.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wulias.project.R;
import com.wulias.project.base.RecycleAdapter;
import com.wulias.project.bean.SelfBean;
import com.wulias.project.tool.ImagLoad;
import com.wulias.navigation.widget.NavigationBar;

import java.util.List;

import butterknife.BindView;

/**
 * Created by 曹小贼 on 2018/8/17.
 */

public class SelfAdapter extends RecycleAdapter<RecycleAdapter.ViewHolder> {

    private List<SelfBean> mDatas;

    public SelfAdapter(Context context, List mDatas) {
        super(context);
        this.mDatas = mDatas;
    }

    @NonNull
    @Override
    public RecycleAdapter.ViewHolder onCreateHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new UserHolder(getItemView(parent, R.layout.item_self_user));
        } else if (viewType == 1) {
            return new OrderHolder(getItemView(parent, R.layout.item_self_order));
        } else if (viewType == 2) {
            return new ToolHolder(getItemView(parent, R.layout.item_self_tool));
        }
        return new OtherHolder(getItemView(parent, R.layout.item_self_other));
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }


    @Override
    public void onBindViewData(RecycleAdapter.ViewHolder holder, int position) {
        SelfBean bean = mDatas.get(position);
        if (bean.getType() == 0) {
            UserHolder userHolder = (UserHolder) holder;
        } else if (bean.getType() == 1) {
            OrderHolder orderHolder = (OrderHolder) holder;
        } else if (bean.getType() == 2) {
            ToolHolder toolHolder = (ToolHolder) holder;
            toolHolder.mTvName.setText(bean.getTitle());
            ImagLoad.install().with(context).load(bean.getRes()).into(toolHolder.mImgCover);
        } else {
            OtherHolder otherHolder = (OtherHolder) holder;
            otherHolder.setLineHeight(bean.getType() == 3);
            otherHolder.mTvTitle.setText(bean.getTitle());
            otherHolder.mTvMsg.setText(bean.getMsg());
            ImagLoad.install().with(context).load(bean.getRes()).into(otherHolder.mImgRight);
        }
    }

    @Override
    public int getItemSpanSize(GridLayoutManager manager, int position) {
        int viewType = mDatas.get(position).getType();
        if (viewType == 2) {
            return 1;
        }
        return 4;
    }

    @Override
    public int getItemViewType(int position) {

        return mDatas.get(position).getType();
    }

    /**
     * 用户信息
     */
    public class UserHolder extends RecycleAdapter.ViewHolder {
        @BindView(R.id.item_self_user_msg)
        TextView mTvMsg;
        public UserHolder(View itemView) {
            super(itemView);
            Resources res = context.getResources();
            Drawable myImage = res.getDrawable(R.mipmap.right);
            myImage.setBounds(1, 1, 10, 18);
            mTvMsg.setCompoundDrawables(null,null,myImage,null);
            mTvMsg.setCompoundDrawablePadding(8);
        }
    }

    /**
     * 订单信息
     */
    public class OrderHolder extends RecycleAdapter.ViewHolder {
        @BindView(R.id.item_self_order_menu)
        NavigationBar mNbMenu;

        public OrderHolder(View itemView) {
            super(itemView);
            // 字体颜色
            mNbMenu.setSelectTextColor(R.color.black);
            mNbMenu.setNormalTextColor(R.color.black);
            //给导航添加item
            mNbMenu.addItem("待支付", R.mipmap.ic_wait_pay, R.mipmap.ic_wait_pay);
            mNbMenu.addItem("待审核", R.mipmap.ic_pending_review, R.mipmap.ic_pending_review);
            mNbMenu.addItem("已审核", R.mipmap.ic_agree_review, R.mipmap.ic_agree_review);
            mNbMenu.addItem("待评价", R.mipmap.ic_pending_comment, R.mipmap.ic_pending_comment);
        }
    }

    /**
     * 工具列表
     */
    public class ToolHolder extends RecycleAdapter.ViewHolder {
        @BindView(R.id.item_self_tool_cover)
        ImageView mImgCover;
        @BindView(R.id.item_self_tool_name)
        TextView mTvName;

        public ToolHolder(View itemView) {
            super(itemView);
        }
    }


    /**
     * 其他选项
     */
    public class OtherHolder extends RecycleAdapter.ViewHolder {
        @BindView(R.id.item_self_other_line)
        View mLine;
        @BindView(R.id.item_self_other_title)
        TextView mTvTitle;
        @BindView(R.id.item_self_other_msg)
        TextView mTvMsg;
        @BindView(R.id.item_self_other_right)
        ImageView mImgRight;

        public OtherHolder(View itemView) {
            super(itemView);
        }

        public void setLineHeight(boolean flag) {
            mLine.setVisibility(flag ? View.VISIBLE : View.GONE);
        }
    }
}
