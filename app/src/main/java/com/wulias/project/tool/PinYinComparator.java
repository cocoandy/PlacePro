package com.wulias.project.tool;


import com.wulias.project.bean.CityBean;

import java.util.Comparator;

/**
 * 按照拼音进行排列
 * Created by 曹小贼
 * 8/10 0010.
 */
public class PinYinComparator implements Comparator<CityBean> {
    @Override
    public int compare(CityBean city, CityBean t1) {
        return city.getCityPinYin().compareTo(t1.getCityPinYin());
    }
}
