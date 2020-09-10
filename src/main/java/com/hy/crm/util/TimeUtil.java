package com.hy.crm.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//日期格式
    private Date date = new Date();//当前日期

    /**
     * 获取当前周
     * @return
     */
    public String[] getThisWeek() {
        String[] dates = new String[2];
        //获取当前日期
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        dates[0] = sdf.format(cal.getTime());
        // System.out.println("所在周星期一的日期：" + dates[0]);
        cal.add(Calendar.DATE, 6);
        dates[1] = sdf.format(cal.getTime());
        // System.out.println("所在周星期日的日期：" + dates[1]);
        return dates;
    }

    /**
     * 获取上周
     * @return
     */
    public String[] getLastWeek() {
        String[] dates = new String[2];
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK) - 1;
        int offset1 = 1 - dayOfWeek;
        int offset2 = 7 - dayOfWeek;
        calendar1.add(Calendar.DATE, offset1 - 7);
        calendar2.add(Calendar.DATE, offset2 - 7);
        // System.out.println(sdf.format(calendar1.getTime()));// last Monday
        //System.out.println("所在周星期一的日期：" + dates[0]);
        dates[0] = sdf.format(calendar1.getTime());
        // System.out.println(sdf.format(calendar2.getTime()));// last Sunday
        //System.out.println("所在周星期日的日期：" + dates[1]);
        dates[1] = sdf.format(calendar2.getTime());
        return dates;
    }

    /**
     * 获取本月
     * @return
     */
    public String[] getThisMonth() {
        String[] dates = new String[2];
        //获取本月第一天
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        dates[0] = sdf.format(cal.getTime());
        //获取本月最后一天
        Calendar cal1=Calendar.getInstance();
        cal1.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        dates[1] = sdf.format(cal1.getTime());
        return dates;
    }
    /**
     * 获取前一个月
     * @return
     */
    public String[] getLastMonth() {
        String[] dates= new String[2];
        //获取前一个月第一天
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.MONTH, -1);
        calendar1.set(Calendar.DAY_OF_MONTH,1);
        dates[0] = sdf.format(calendar1.getTime());
        //获取前一个月最后一天
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.DAY_OF_MONTH, 0);
        dates[1] = sdf.format(calendar2.getTime());
        return dates;
    }

    /**
     * 获取本季度
     * @return
     */
    public String[] getCurrentSeason() {
        String[] dates= new String[2];

        //取得日历
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int year = calendar.get(Calendar.YEAR);// 本季度的年份
        int mouth = calendar.get(Calendar.MONTH);// 本季度的月份

        // 根据月份,判断是哪个季度
        switch( mouth){
            case 1:
            case 2:
            case 3:
                dates[0] = year+"-01-01";// 第一季度第一天是1-1
                dates[1] = year+"-03-31";// 第一季度最后一天是3-31
                break;
            case 4:
            case 5:
            case 6:
                dates[0] = year+"-04-01";// 第二季度第一天是4-1
                dates[1] = year+"-06-30";// 第二季度最后一天是6-31
                break;
            case 7:
            case 8:
            case 9:
                dates[0] = year+"-07-01";// 第三季度第一天是7-31
                dates[1] = year+"-09-30";// 第三季度最后一天是9-30
                break;
            case 10:
            case 11:
            case 12:
                dates[0] = year+"-10-01";// 第四季度第一天是10-1
                dates[1] = year+"-12-31";// 第四季度最后一天是12-31
                break;
        }

        return dates;
    }

    /**
     * 获取上季度
     * @return
     */
    public String[] getPrecedingQuarter() {
        String[] dates= new String[2];

        //取得日历
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        // 日历减3个月,即上季度
        calendar.add(Calendar.MONTH,-3);

        int year = calendar.get(Calendar.YEAR);// 上季度的年份
        int mouth = calendar.get(Calendar.MONTH);// 上季度的月份

        // 根据月份,判断是哪个季度
        switch( mouth){
            case 1:
            case 2:
            case 3:
                dates[0] = year+"-01-01";// 第一季度第一天是1-1
                dates[1] = year+"-03-31";// 第一季度最后一天是3-31
                break;
            case 4:
            case 5:
            case 6:
                dates[0] = year+"-04-01";// 第二季度第一天是4-1
                dates[1] = year+"-06-30";// 第二季度最后一天是6-31
                break;
            case 7:
            case 8:
            case 9:
                dates[0] = year+"-07-01";// 第三季度第一天是7-31
                dates[1] = year+"-09-30";// 第三季度最后一天是9-30
                break;
            case 10:
            case 11:
            case 12:
                dates[0] = year+"-10-01";// 第四季度第一天是10-1
                dates[1] = year+"-12-31";// 第四季度最后一天是12-31
                break;
        }

        return dates;
    }

}
