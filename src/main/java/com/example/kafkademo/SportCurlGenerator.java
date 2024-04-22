/*
 * Copyright (c) 2014-2023 Huami, Inc. All Rights Reserved.
 */

package com.example.kafkademo;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SportCurlGenerator {

    public static void main(String[] args) throws IOException {

        String appToken = "ZQVBQEJyQktGXip6SltGSlpuQkZgBAAEAAAAAPklz-pwnORAHfQZ4uLkr2Ce7ADLB3-AkCW_iynkuLlJEoU60mUrhoyiDNzVuj-l19E1kYCMCfO3eL21MgZgiFRLZ2vY73F0Z8q1R1fpsRrwdsbgJKuCXwjWkeHYALmUNqf31rdJxEtbPPORYhnec22-TrAR1I7I8Nhoe3L8eeyhV7E74sPuldUceN7mxIfic";
        String filePath1 = "D:\\project\\kafkaDemo\\src\\main\\resources\\detail";
        String detail = convert(filePath1);
//
        String filePath2 = "D:\\project\\kafkaDemo\\src\\main\\resources\\summary";
        String summary = convert(filePath2);
//
        String summaryUrl = "v1/sport/run/summary.json";
        String detailUrl = "v1/sport/run/detail.json";
//
        String trackid = "1705815772";
        String userid = "1062258552";
//
        String curlCommand = generateCurlCommand(appToken, JSONObject.parseObject(summary), summaryUrl, trackid, userid);
//        String curlCommand = generateCurlCommand(appToken, JSONObject.parseObject(detail), detailUrl,trackid,userid);
        System.out.println(curlCommand);
    }

    public static String generateCurlCommand(String appToken, JSONObject jsonObject, String url, String trackid, String userid) {
        StringBuilder curlCommand = new StringBuilder();
        curlCommand.append(String.format("curl --location 'https://api-mifit-cn3.zepp.com/%s?r=a5bfe77d-efbf-41f1-b308-cb75fc25dfa4&t=1665382199082' \\\n", url));
        curlCommand.append(String.format("--header 'apptoken: %s' \\\n", appToken));
        curlCommand.append("--header 'lang: zh-cn' \\\n");
        curlCommand.append(String.format("--header 'xReqId: %s' \\\n", System.currentTimeMillis()));
        curlCommand.append("--header 'time;' \\\n");
        curlCommand.append("--header 'appname: com.xiaomi.hm.health' \\\n");
        curlCommand.append("--header 'timezone: Asia/Shanghai'");

        jsonObject.entrySet().forEach(entry -> {
            String key = entry.getKey();
            String value = entry.getValue().toString();
            if (Objects.equals(key, "trackid")) {
                value = trackid;
            }
            if (Objects.equals(key, "userid")) {
                value = userid;
            }


            curlCommand.append(" \\\n--form '").append(key).append("=\"").append(value).append("\"'");
        });

        return curlCommand.toString();
    }

    public static String convert(String filePath) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        }
        return stringBuilder.toString();
    }
}