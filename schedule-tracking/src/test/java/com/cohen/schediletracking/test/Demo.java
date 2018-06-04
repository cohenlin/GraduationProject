package com.cohen.schediletracking.test;

import com.cohen.scheduletracking.utils.MD5Util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 林金成
 * @date 2018/5/718:43
 */
public class Demo {
    public static void shellSort(int[] a) {
        int d = a.length;
        int key, i, j, k;
        while (true) {
            d = d / 2;// 增量
            for (i = 0; i < d; i++) {
                for (j = i + d; j < a.length; j += d) {// 从d,d+1,d+2处开始向后遍历，分别跟0,1,2处比较大小，若d,d+1,d+2处元素小，则前面均后移一位，并将小的元素插在空位
                    key = a[j];
                    for (k = j - d; k >= 0; k -= d) {
                        if (key < a[k]) {// 后边元素小，需要向前插入
                            // 前面元素后移一个单位d
                            a[k + d] = a[k];
                        } else { // 后面元素大，不需要向前插入
                            break;
                        }
                    }
                    a[k + d] = key;
                }
            }

            // 当步长为1的时候跳出while循环
            if (d <= 1) {
                break;
            }
        }
    }

    public static void main(String[] args) {
//        int[] a = {18, 17, 21, 25, 23, 24, 14, 30, 29, 31, 28, 37, 27, 34, 44, 41, 39, 36, 32, 48, 43, 38, 26, 52, 40, 33, 46, 47, 50, 57, 35, 55, 51, 53, 42, 58, 45, 54, 49, 59, 65};
//        shellSort(a);
//        System.out.print(Arrays.toString(a));
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String todayStr = sdf.format(new Date());
//        System.out.println(todayStr);
        System.out.println(MD5Util.MD5("Test123"));
    }
}