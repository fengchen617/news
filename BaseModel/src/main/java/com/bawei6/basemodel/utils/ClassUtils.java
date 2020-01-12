package com.bawei6.basemodel.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author fengchen
 * @date 2020/1/12.
 * 类型工具类
 */
public class ClassUtils {
    /**
     * 获取泛型类型
     * @param obj
     * @return
     */
    public static Class<?> getParameterizedClazz(Object obj){
        Type t= obj.getClass().getGenericSuperclass();
        ParameterizedType p=(ParameterizedType)t;
        Class c=(Class) p.getActualTypeArguments()[0];
        return c;
    }
}
