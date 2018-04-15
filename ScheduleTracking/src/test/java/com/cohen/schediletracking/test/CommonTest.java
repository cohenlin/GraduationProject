package com.cohen.schediletracking.test;

import com.cohen.scheduletracking.entity.Task;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CommonTest {

    public static void main(String[] args) {
        try {
            Task t = Task.class.newInstance();
            Method[] methods = Task.class.getDeclaredMethods();
            Field[] fields = t.getClass().getDeclaredFields();
            for (Field d:
                 fields) {
                if(d.getName().equals("id")){
                    d.setAccessible(true);
                    d.set(t, 2);
                }
            }
            for (Method m:
                    methods) {
                if(m.getName().equals("setId")){
                    try {
                        m.invoke(t, 1);
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(t.getId());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
