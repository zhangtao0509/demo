/*
 * Copyright (c) 2014-2023 Huami, Inc. All Rights Reserved.
 */

package com.example.kafkademo;

import org.springframework.util.NumberUtils;

import java.text.DecimalFormat;
import java.util.Objects;

public class FeatureTest {

    public static void main(String[] args) {
//        Long feature = 1L;
//        int mask = 1 << 2; // 创建掩码，值为0b00000100
//        if (Objects.nonNull(feature) && !Objects.equals(feature, -1L)
//                && (feature.intValue() & mask) == mask) {
//            System.out.println("mask = " + true);
//        } else {
//            System.out.println("mask = " + false);
//        }
//        double roundedResult = divideAndRound(10, 3, 3);
//
//        System.out.println("结果：" + roundedResult);

        //组装平均心率数据
        double totalDenominator = 112*408;
        double totalNumerator = 408;
        double avgHeartRate = Double.parseDouble(new DecimalFormat("#.00").format(totalDenominator / totalNumerator));
        System.out.println("avgHeartRate = " + avgHeartRate);

    }

    // 方法接受两个参数：被除数和除数，返回结果保留指定小数位数
    public static double divideAndRound(double numerator, double denominator, int decimalPlaces) {
        if (denominator == 0) {
            return 0.0;
        }

        double result = numerator / denominator;
        double scaleFactor = Math.pow(10, decimalPlaces);
        return Math.round(result * scaleFactor) / scaleFactor;
    }
}