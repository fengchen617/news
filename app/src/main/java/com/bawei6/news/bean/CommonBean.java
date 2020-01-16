package com.bawei6.news.bean;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * @author fengchen
 * @date 2020/1/15.
 * @description：选项卡的Bean
 */
public class CommonBean implements CustomTabEntity {
    String msg;
    int a;
    int b;

    public CommonBean(String msg, int a, int b) {
        this.msg = msg;
        this.a = a;
        this.b = b;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String getTabTitle() {
        return msg;
    }

    @Override
    public int getTabSelectedIcon() {
        return a;
    }

    @Override
    public int getTabUnselectedIcon() {
        return b;
    }
}
