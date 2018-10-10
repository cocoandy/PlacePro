package com.wulias.project.bean;

import com.wulias.project.base.BaseBean;

/**
 * Created by Administrator on 2018/7/25.
 */

public class CityBean extends BaseBean {
    //城市名称拼音
    private String cityPinYin;

    //城市名称
    private String cityName;

    //拼音首字母
    private String firstPinYin;

    //隐藏，展开字母列表项
    private boolean hideEnable;

    public String getCityPinYin() {
        return cityPinYin;
    }

    public void setCityPinYin(String cityPinYin) {
        this.cityPinYin = cityPinYin;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getFirstPinYin() {
        return firstPinYin;
    }

    public void setFirstPinYin(String firstPinYin) {
        this.firstPinYin = firstPinYin;
    }

    public boolean isHideEnable() {
        return hideEnable;
    }

    public void setHideEnable(boolean hideEnable) {
        this.hideEnable = hideEnable;
    }
}
