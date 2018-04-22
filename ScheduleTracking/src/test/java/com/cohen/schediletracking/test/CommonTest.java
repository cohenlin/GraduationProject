package com.cohen.schediletracking.test;

import com.cohen.scheduletracking.entity.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RunWith(JUnit4.class)
public class CommonTest {


    @Test
    public void test1() {
        File mappers = new File("/mappers");
        String[] list = mappers.list();
        for (String str : list
                ) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        try {
            Task t = Task.class.newInstance();
            Method[] methods = Task.class.getDeclaredMethods();
            Field[] fields = t.getClass().getDeclaredFields();
            for (Field d :
                    fields) {
                if (d.getName().equals("id")) {
                    d.setAccessible(true);
                    d.set(t, 2);
                }
            }
            for (Method m :
                    methods) {
                if (m.getName().equals("setId")) {
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
