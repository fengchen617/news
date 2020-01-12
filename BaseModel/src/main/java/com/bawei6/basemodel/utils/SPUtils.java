package com.bawei6.basemodel.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author fengchen
 * @date 2020/1/12.
 * @description：SP的工具类
 */
public class SPUtils {

    private static volatile SPUtils singleton;

    private SPUtils() {
    }

    public static SPUtils getInstance() {
        if (singleton == null) {
            synchronized (SPUtils.class) {
                if (singleton == null) {
                    singleton = new SPUtils();
                }
            }
        }
        return singleton;
    }

    /**
     * 获取String类型
     * @param context
     * @param key
     * @return
     */
    public String getString(Context context,String key){
        SharedPreferences a = context.getSharedPreferences("a", Context.MODE_PRIVATE);
        return a.getString(key,"");
    }
    /**
     * 获取Boolean类型
     * @param context
     * @param key
     * @return
     */
    public boolean getflag(Context context,String key){
        SharedPreferences a = context.getSharedPreferences("a", Context.MODE_PRIVATE);
        return a.getBoolean(key,false);
    }
    /**
     * 获取整数类型
     * @param context
     * @param key
     * @return
     */
    public int getint(Context context,String key){
        SharedPreferences a = context.getSharedPreferences("a", Context.MODE_PRIVATE);
        return a.getInt(key,0);
    }
    /**
     * 存储String类型
     * @param context
     * @param key
     * @return
     */
    public void setString(Context context,String key,String value){
        SharedPreferences a = context.getSharedPreferences("a", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = a.edit();
        edit.putString(key,value).commit();
    }
    /**
     * 存储Boolean类型
     * @param context
     * @param key
     * @return
     */
    public void setBoolean(Context context,String key,boolean value){
        SharedPreferences a = context.getSharedPreferences("a", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = a.edit();
        edit.putBoolean(key,value).commit();
    }
    /**
     * 存储整数类型
     * @param context
     * @param key
     * @return
     */
    public void setsp(Context context,String key,int value){
        SharedPreferences a = context.getSharedPreferences("a", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = a.edit();
        edit.putInt(key,value).commit();
    }
}