package com.bawei6.news.bean;

/**
 * @author fengchen
 * @date 2020/1/15.
 * @description：登录
 */
public class LoginBean {

    /**
     * id : 432
     * username : 11111111111
     * pwd : null
     * sex : samp
     * brithday : sample string 5
     */

    private int id;
    private String username;
    private Object pwd;
    private String sex;
    private String brithday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Object getPwd() {
        return pwd;
    }

    public void setPwd(Object pwd) {
        this.pwd = pwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBrithday() {
        return brithday;
    }

    public void setBrithday(String brithday) {
        this.brithday = brithday;
    }
}
