package com.hy.crm.utils;

import java.util.List;

/**
 * @author kw
 * @version 1.0
 * @description消息管理对象
 * @date 2020/9/5 13:41 星期六
 */

public class MsgMag {
    private int code;
    private String msg;
    private int count;
    private List data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
