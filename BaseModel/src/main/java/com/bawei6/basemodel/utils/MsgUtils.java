package com.bawei6.basemodel.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * @author fengchen
 * @date 2020/1/12.
 * @description：消息工具类
 */
public class MsgUtils {
    /**
     * 打印log工作类
     * @param msg 消息
     */
    public static void log(String msg){
        Log.i(NumberPool.LOGTAG,msg);
    }

    /**
     * Toast展示数据
     * @param context 上下文
     * @param msg  消息
     */
    public static void showmsg(Context context,String msg){
        Toast.makeText(context,msg, Toast.LENGTH_SHORT).show();
    }
}