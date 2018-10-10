package com.wulias.project.bean;

import java.util.List;

/**
 * 首页内容
 * Created by 曹小贼 on 2018/8/15.
 */

public class HomeBean<T> {

    private String title;//标题
    private int type;//类型
    private int price;//价格
    private String cover;//封面
    private List<T> list;//数据列表

    private int index;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
