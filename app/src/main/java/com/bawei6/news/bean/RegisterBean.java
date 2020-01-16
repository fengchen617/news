package com.bawei6.news.bean;

/**
 * @author fengchen
 * @date 2020/1/15.
 * @description：注册时的Bean类
 */
public class RegisterBean {

    /**
     * id : 1
     * username : sample string 2
     * pwd : sample string 3
     * sex : sample string 4
     * brithday : sample string 5
     */

    private int id;
    private String username;
    private String pwd;
    private String sex;
    private String brithday;

    public RegisterBean(int id, String username, String pwd, String sex, String brithday) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.sex = sex;
        this.brithday = brithday;
    }

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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
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
