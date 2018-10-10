package com.wulias.project.tool;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 时间管理
 * Created by 曹小贼 on 2018/10/9.
 */

public class DateTool {
    /**
     * add by gongtao
     * <p>
     * 将Date类型的日期格式 转换为 符合要求的 String日期格式
     * </P>
     *
     * @param date
     * @param format
     * @return
     */
    public static String getStrDate4Date(Date date, String format) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat df = new SimpleDateFormat(format);
            return df.format(date);
        }
    }

    /**
     * 获取指定日期时间的小时和分钟数
     *
     * @param date
     * @return
     */
    public static String getHHMm(Date date) {
        String hm = getDateTimeStr(date);
        return hm.substring(11, 16);
    }


    /**
     * <p>获取格式化字符串日期时间，返回字符串格式</p>
     * 格式：yyyy-MM-dd HH:mm:ss
     *
     * @param date 指定日期对象
     * @return 返回日期时间字符串格式：yyyy-MM-dd HH:mm:ss
     */
    public static String getDateTimeStr(Date date) {
        return yMd_Hms.format(date);
    }

    /**
     * 格式：yyyy-MM-dd HH:mm:ss
     */
    public static SimpleDateFormat yMd_Hms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取时间戳是那一天 当天是0 以此类推
     *
     * @return
     */
    public static int getDayInYear(long time) {
        Calendar today = getCalendar(System.currentTimeMillis());
        Calendar date = getCalendar(time);
        return date.get(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR);
    }
    /**
     * 时间戳转Calendar
     *
     * @param time
     * @return
     */
    public static Calendar getCalendar(long time) {
        Calendar calendar = new GregorianCalendar();
        Date date = new Date(time);
        calendar.setTime(date);
        return calendar;
    }

    /**
     * 计算日期
     *
     * @param starTime
     */
    public static String calculateDate(long starTime) {
        String date = DateTool.getStrDate4Date(new Date(starTime), "MM月dd日");
        int time = DateTool.getDayInYear(starTime);
        switch (time) {
            case 0:
                date = "今天" + date;
                break;
            case 1:
                date = "明天" + date;
                break;
            case 2:
                date = "后天" + date;
                break;
        }
        return date;
    }
}
