package com.wulias.project.weight;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.wulias.project.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @author tylz
 * @time 2016/3/31 0031 14:04
 * @des 自定义个进度条
 * @updateAuthor
 * @updateDate 2016/3/31 0031
 * @updateDes
 */
public class ProgressDialog extends Dialog {
    @BindView(R.id._tv_loading_msg)
    TextView mTvLoadingMsg;
    @BindView(R.id._progress_bar)
    ProgressBar mProgressBar;

    public ProgressDialog(Context context) {
        super(context, R.style.progress_dialog);
        initView();
    }


    public ProgressDialog(Context context, int theme) {
        super(context, theme);
        initView();
    }

    private void initView() {
        setContentView(R.layout.view_progress_dialog);
        ButterKnife.bind(this);
        setCancelable(true);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        mTvLoadingMsg.setText("Loadding");
    }

    public void setTip(int resId) {
        mTvLoadingMsg.setText("");
    }

    public void setTip(String tip) {
        mTvLoadingMsg.setText(tip);
    }

    public void setIcon(Drawable resId) {
        mProgressBar.setIndeterminateDrawable(resId);
    }

    public void setText(String text) {
        mTvLoadingMsg.setText(text);
    }
}
