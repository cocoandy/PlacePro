package com.wulias.project.listener;

import android.view.View;

import com.wulias.project.weight.FlowTagLayout;

/**
 * Created by HanHailong on 15/10/20.
 */
public interface OnTagClickListener {
    void onItemClick(FlowTagLayout parent, View view, int position);
}
