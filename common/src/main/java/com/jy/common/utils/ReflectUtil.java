package com.jy.common.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * can not find lambda cache for this entity [com.jy.common.pojo.User]
 * 
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-08-01 15:03
 */
public class ReflectUtil {

    /**
     * 私有化构造函数
     */
    private ReflectUtil() {
    }

    /**
     * 获取父类泛型 类型集合
     * 
     * @param clazz
     * @return
     */
    public static Type[] getGenericParamClassArray(Class<?> clazz) {
        ParameterizedType genericSuperclass = getType(clazz);
        if (genericSuperclass == null) {
            throw new RuntimeException("Generic super class is null");
        } else {
            return genericSuperclass.getActualTypeArguments();
        }
    }

    private static ParameterizedType getType(Class<?> clazz) {
        for (int index = 0; index < 5; ++index) {
            Type superType = clazz.getGenericSuperclass();
            if (superType instanceof ParameterizedType) {
                return (ParameterizedType) superType;
            }

            clazz = clazz.getSuperclass();
        }

        return null;
    }

}
