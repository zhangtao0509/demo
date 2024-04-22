/*
 * Copyright (c) 2014-2023 Huami, Inc. All Rights Reserved.
 */

package com.example.kafkademo;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {

    private static Map<String, Map<String, String>> data = new HashMap<>();

    static {
        // 构建 strava 数据
        Map<String, String> stravaData = new HashMap<>();
        stravaData.put("1", "run");
        stravaData.put("2", "run");
        // 添加更多数据...

        // 构建 trainingpeaks 数据
        Map<String, String> trainingPeaksData = new HashMap<>();
        trainingPeaksData.put("1", "run");
        trainingPeaksData.put("2", "run");
        // 添加更多数据...

        // 构建 relive 数据
        Map<String, String> reliveData = new HashMap<>();
        reliveData.put("1", "run");
        reliveData.put("7", "run");
        // 添加更多数据...

        // 构建 komoot 数据
        Map<String, String> komootData = new HashMap<>();
        komootData.put("11", "alpine_skiing");
        komootData.put("43", "alpine_skiing");
        // 添加更多数据...

        // 将数据添加到静态 Map
        data.put("strava", stravaData);
        data.put("trainingpeaks", trainingPeaksData);
        data.put("relive", reliveData);
        data.put("komoot", komootData);
    }
}