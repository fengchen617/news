package com.bawei6.news.bean;

/**
 * @author fengchen
 * @date 2020/1/12.
 * @description：
 */
public class SelectBean {

    /**
     * id : 1
     * typename : 游戏
     */

    private int id;
    private String typename;

    public SelectBean(int id, String typename) {
        this.id = id;
        this.typename = typename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }
}
