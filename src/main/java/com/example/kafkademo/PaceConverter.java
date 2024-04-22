/*
 * Copyright (c) 2014-2023 Huami, Inc. All Rights Reserved.
 */

package com.example.kafkademo;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

public class PaceConverter {

    public static double convertSecondsPerMeterToMinutesPerHundredMeters(double secondsPerMeter) {
        // 转换为分钟/千米
        double minutesPerKilometer = (secondsPerMeter * 60) / 1000;

        // 转换为分钟/百米
        double minutesPerHundredMeters = minutesPerKilometer / 10;

        return minutesPerHundredMeters;
    }

    public static void main(String[] args) {
        double secondsPerMeter = 240.0; // 假设配速为240秒/米

        double minutesPerHundredMeters = convertSecondsPerMeterToMinutesPerHundredMeters(secondsPerMeter);

        System.out.println("配速：" + secondsPerMeter + " 秒/米");
        System.out.println("转换后的配速：" + minutesPerHundredMeters + " 分钟/百米");
    }
}
