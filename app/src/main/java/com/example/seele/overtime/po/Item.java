package com.example.seele.overtime.po;

/**
 * 时间管理-数据库-实体类
 */
public class Item {

    //标题
    public String title;

    //时长 分钟
    public int minutes;

    //日期 yyyymmdd
    public String date;

    //flg，0表示主类，1表示待办
    public String flg;

    //表名
    public static final String TABLENAME = "overtime";

    //无参构造方法
    public Item(){
    }

    //有参构造方法
    public Item(String title, int minutes, String date, String flg){
        this.title = title;
        this.minutes = minutes;
        this.date = date;
        this.flg = flg;
    }
}
