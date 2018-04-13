package com.cohen.schediletracking.test;

import com.alibaba.fastjson.JSON;
import com.cohen.scheduletracking.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class CommonTest {

    public static void main(String[] args) {
        List<Task> result = new ArrayList<>();
        result.add(new Task());
        result.add(new Task());
        result.add(new Task());
        String jsonObject = JSON.toJSONString(result);
        System.out.println(jsonObject);
    }
}
