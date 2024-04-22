/*
 * Copyright (c) 2014-2023 Huami, Inc. All Rights Reserved.
 */

package com.example.kafkademo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DEMTest {

    public static void main(String[] args) throws IOException {
        String filePath = "D:\\project\\kafkaDemo\\src\\main\\resources\\DEM_TRANSFORM";
        String str = convert(filePath);
        parsePointLocationList(str);
//        unNormal ();
    }

    public static void parsePointLocationList(String bulkGps) {
        List<List<Double>> listList = new ArrayList<>();
        String[] gpsStrList = bulkGps.split(";");
        long prevLat = 0;
        long prevLongi = 0;
        for (int index = 0; index < gpsStrList.length; index++) {
            try {
                String str = gpsStrList[index];
                String[] pointLL = str.split(",");
                prevLat += Long.parseLong(pointLL[0]);
                prevLongi += Long.parseLong(pointLL[1]);
                double scaledLat = scaleDouble(prevLat / 100000000.0, 5);
                double scaledLongi = scaleDouble(prevLongi / 100000000.0, 5);
                listList.add(Arrays.asList(scaledLat, scaledLongi));
            } catch (Exception e) {
                System.out.println("e = " + e);
            }

        }
        System.out.println("size = " + listList.size());
        System.out.println("listList = " + JSONObject.toJSONString(listList));
    }

    public static double scaleDouble(double value, int scale) {
        double scaleFactor = Math.pow(10, scale);
        return Math.round(value * scaleFactor) / scaleFactor;
    }

    public static void unNormal() throws IOException {
        String filePath = "D:\\project\\kafkaDemo\\src\\main\\resources\\DEM_TRANSFORM";
        String str = convert(filePath);
        List<String> strings = JSONArray.parseArray(str, String.class);
        for (String string : strings) {
            List<Double> stringChild = JSONArray.parseArray(string, Double.class);
            if (stringChild.get(2) < 0) {
                System.out.println("stringChild = " + stringChild);
            }
        }
    }


    public static String convert(String filePath) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        }

        return stringBuilder.toString();
    }
}