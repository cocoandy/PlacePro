package com.wulias.project.presenter;

import android.support.v7.widget.LinearLayoutManager;

import com.wulias.project.base.Presenter;
import com.wulias.project.bean.CityBean;
import com.wulias.project.util.PinYinComparator;
import com.wulias.project.util.Tool;
import com.wulias.project.view.IMainView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 城市列表业务层
 * Created by Administrator on 2018/7/25.
 */

public class CityPresenter extends Presenter<IMainView> {

    public List<CityBean> mDatas = new ArrayList<>();
    public List<String> mLetterDatas;
    public Map<Integer, String> mTitles = new HashMap<>();

    /**
     * 创建假数据
     *
     * @param cityName
     * @return
     */
    private CityBean getCity(String cityName) {
        CityBean city = new CityBean();
        city.setCityName(cityName);
        city.setHideEnable(false);
        city.setCityPinYin(Tool.transformPinYin(city.getCityName()));
        if (city.getCityPinYin() != null && city.getCityPinYin().length() >= 1) {
            city.setFirstPinYin(city.getCityPinYin().substring(0, 1));
        }
        return city;
    }

    /**
     * 初始化假数据
     */
    public void getDatas() {

        for (int i = 0; i < stringCitys.length; i++) {
            CityBean bean = getCity(stringCitys[i]);
            mDatas.add(bean);
        }

        Collections.sort(mDatas, new PinYinComparator());

        getNavigationDatas();

        getFloatItemDatas();
    }

    public int getLetterDataIndex(String value) {
        if (mLetterDatas.contains(value)) {

            return mLetterDatas.indexOf(value);
        }
        return 0;
    }

    /**
     * 根据数据列表获取到列表拼音导航数据
     *
     * @return
     */
    public List<String> getNavigationDatas() {
        if (mLetterDatas == null) {
            mLetterDatas = new ArrayList<>();
        } else {
            mLetterDatas.clear();
        }

        List<String> datas = new ArrayList<>();
        for (CityBean city : mDatas) {
            if (!datas.contains(city.getFirstPinYin())) {
                datas.add(city.getFirstPinYin());
            }
        }
        return mLetterDatas = datas;
    }

    /**
     * 根据数据列表获取到列表拼音导航数据
     *
     * @return
     */
    public Map<Integer, String> getFloatItemDatas() {
        if (mTitles == null) {
            mTitles = new HashMap<>();
        } else {
            mTitles.clear();
        }

        Map<Integer, String> map = new HashMap<>();

        for (int i = 0, len = mDatas.size(); i < len; i++) {
            if (!mDatas.get(i).getFirstPinYin().equals(i > 0 ? mDatas.get(i - 1).getFirstPinYin() : "")) {
                // 最后一项和前一项比，如果不相等的话就是新的标题
                map.put(i, mDatas.get(i).getFirstPinYin());
            }
        }
        return mTitles = map;
    }


    /**
     * RecyclerView 移动到当前位置，
     *
     * @param manager 设置RecyclerView对应的manager
     * @param n       要跳转的位置
     */
    public void MoveToPosition(LinearLayoutManager manager, int n) {
        int firstItemPosition = manager.findFirstVisibleItemPosition();
        int lastItemPosition = manager.findLastVisibleItemPosition();
        if (!(firstItemPosition == 0 && lastItemPosition == mDatas.size())){
            manager.scrollToPositionWithOffset(n, 0);
            manager.setStackFromEnd(true);
        }

    }

    private static String[] stringCitys = new String[]{
            "安定", "张家界", "黄山", "淮北", "阜阳", "蚌埠", "淮南", "滁州",
            "洛阳", "芜湖", "铜陵", "安庆", "安阳", "黄山", "六安", "巢湖",
            "池州", "宣城", "亳州", "明光", "天长", "桐城", "宁国",
            "徐州", "连云港", "宿迁", "淮安", "盐城", "扬州", "长安",
            "南通", "镇江", "常州", "无锡", "苏州", "江阴", "广安",
            "邳州", "新沂", "金坛", "溧阳", "常熟", "张家港", "太仓",
            "昆山", "吴江", "如皋", "通州", "海门", "晋江", "大丰",
            "东台", "高邮", "仪征", "江都", "扬中", "句容", "丹阳",
            "兴化", "姜堰", "泰兴", "靖江", "福州", "南平", "三明",
            "邻水", "上海", "深圳", "香港", "乐山", "文淑", "重庆"
    };

}
