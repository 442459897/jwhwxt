package com.muran.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Steven on 3/17/16.
 */
public class JavaReflexUtil {
    private final static String TAG = "JavaReflexUtil";

    /**
     * java反射bean的get方法
     *
     * @param objectClass
     * @param fieldName
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Method getGetMethod(Class objectClass, String fieldName) {
        StringBuffer sb = new StringBuffer();
        try {
            Field field = objectClass.getDeclaredField(fieldName);
            if(field.getType().getSimpleName().equalsIgnoreCase("Boolean")) sb.append("is");
            else sb.append("get");
            sb.append(fieldName.substring(0, 1).toUpperCase());
            sb.append(fieldName.substring(1));
            return objectClass.getMethod(sb.toString());
        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
            //Log.d(TAG,"No Field: "+fieldName+" in "+objectClass.getSimpleName());
        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
            //Log.d(TAG, "No get method for field: " + fieldName + " in " + objectClass.getSimpleName());
        }
        return null;
    }

    /**
     * java反射bean的set方法
     *
     * @param objectClass
     * @param fieldName
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Method getSetMethod(Class objectClass, String fieldName) {
        try {
            Class[] parameterTypes = new Class[1];
            Field field = objectClass.getDeclaredField(fieldName);
            parameterTypes[0] = field.getType();
            StringBuffer sb = new StringBuffer();
            sb.append("set");
            sb.append(fieldName.substring(0, 1).toUpperCase());
            sb.append(fieldName.substring(1));
            Method method = objectClass.getMethod(sb.toString(), parameterTypes);
            return method;
        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
            //Log.d(TAG, "No Field: " + fieldName + " in " + objectClass.getSimpleName());
        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
            //Log.d(TAG, "No set method for field: " + fieldName + " in " + objectClass.getSimpleName());
        }
        return null;
    }


    /**
     * 执行set方法
     *
     * @param o         执行对象
     * @param fieldName 属性
     * @param value     值
     */
    public static void invokeSet(Object o, Class clazz,String fieldName, Object value) {
        Method method = getSetMethod(clazz, fieldName);
        if(method==null)return;
        try {
            method.invoke(o, new Object[]{value});
        } catch (IllegalAccessException e) {
//            e.printStackTrace();
            //Log.d(TAG,"Class "+clazz + " setmethod for filed:"+fieldName+"  IllegalAccessException");
        } catch (InvocationTargetException e) {
//            e.printStackTrace();
            //Log.d(TAG, "Class " + clazz + " setmethod for filed:" + fieldName + "  InvocationTargetException");
        }
    }

    /**
     * 执行get方法
     *
     * @param o         执行对象
     * @param fieldName 属性
     */
    public static Object invokeGet(Object o,Class clazz, String fieldName) {
        Method method = getGetMethod(clazz, fieldName);
        if(method==null)return null;

        try {
            return method.invoke(o, new Object[0]);
        }catch (IllegalAccessException e) {
//            e.printStackTrace();
            //Log.d(TAG,"Class "+clazz + " setmethod for filed:"+fieldName+"  IllegalAccessException");
        } catch (InvocationTargetException e) {
//            e.printStackTrace();
            //Log.d(TAG, "Class " + clazz + " setmethod for filed:" + fieldName + "  InvocationTargetException");
        }


        return null;
    }
}
