package com.wulias.project.bean.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/9.
 */

public class GroundBean implements Serializable {

   private boolean isSelect;
   private String name;
   private String title;
   private String cover;

    public GroundBean(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
