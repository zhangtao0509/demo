/*
 * Copyright (c) 2014-2024 Huami, Inc. All Rights Reserved.
 */

package com.example.kafkademo.golf;


import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class GolfService {


    public static String host = "https://api-connect.igolf.com/rest/action";
    public static String signMethod = "HmacSHA256";
    public static String CHARACTER_ENCODING = "UTF-8";
    public static String signVersion = "2.0";
    public static String responseFormat = "JSON";
    public static String apiVersion = "1.1";
    public static String appApiKey = "ATu_Qwem3FAoWPE";
    public static String secretKey = "xoihPSMTYTSnnhqP6V0y7sTDEWpEdL";
    public static String timeFormat = "yyMMddHHmmssZZZZZ";

    public static String calculateSignature(String toSignStr, String signMethod, String secretKey)
            throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        Mac mac = Mac.getInstance(signMethod);
        mac.init(new SecretKeySpec(secretKey.getBytes(CHARACTER_ENCODING), mac.getAlgorithm()));
        byte[] rawSig = mac.doFinal(toSignStr.getBytes(CHARACTER_ENCODING));
        return Base64.encodeBase64URLSafeString(rawSig); // use Base64 with URL and Filename Safe Alphabet (RFC 4648 'base64url' encoding)
    }

    public static String toSign(String actionCode, String appApiKey, String apiVersion, String signVersion, String signMethod, String timestampStr, String responseFormat) {
        StringBuilder builder = new StringBuilder();
        builder.append(actionCode)
                .append("/").append(appApiKey)
                .append("/").append(apiVersion)
                .append("/").append(signVersion)
                .append("/").append(signMethod)
                .append("/").append(timestampStr)
                .append("/").append(responseFormat);
        return builder.toString();
    }

    public static String buildMethodUrl(String actionCode) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        DateFormat sdf = new SimpleDateFormat(timeFormat);
        String timestampStr = sdf.format(new Date());
        String toSignStr = toSign(actionCode, appApiKey, apiVersion, signVersion, signMethod, timestampStr, responseFormat);
        String signature = calculateSignature(toSignStr, signMethod, secretKey);
        // 构建 signedPath 字符串
        String signedPath = appApiKey + "/" + apiVersion + "/" + signVersion + "/" + signMethod + "/" + signature + "/" + timestampStr + "/" + responseFormat;
        return host + "/" + actionCode + "/" + signedPath;
    }

    public static CourseListResponse getCourseList(CourseListRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        String url = buildMethodUrl("CourseList");
        Map<String, Object> map = new HashMap<>();
        map.put("active", request.getActive());
        map.put("courseName", request.getCourseName());
        String responseStr = HttpRequest.post(url).body(JSONObject.toJSONString(map)).execute().body();
        return JSONObject.parseObject(responseStr, CourseListResponse.class);
    }

    public static CourseDetailsResponse getCourseDetail(CourseDetailsRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        String url = buildMethodUrl("CourseDetails");
        Map<String, Object> map = new HashMap<>();
        map.put("id_course", request.getId_course());
        map.put("stateFormat", request.getStateFormat());
        map.put("countryFormat", request.getCountryFormat());
        map.put("detailLevel", request.getDetailLevel());
        String responseStr = HttpRequest.post(url).body(JSONObject.toJSONString(map)).execute().body();
        return JSONObject.parseObject(responseStr, CourseDetailsResponse.class);
    }

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
//        CourseListRequest request = new CourseListRequest();
//        request.setActive(1);
//        request.setCourseName("admiral baker");
//        CourseListResponse courseList = getCourseList(request);
//        System.out.println("courseList = " + JSONObject.toJSONString(courseList));

        CourseDetailsRequest request = new CourseDetailsRequest();
        request.setId_course("ye90ua54nOCk");
        request.setDetailLevel(2);
        request.setCountryFormat(4);
        request.setStateFormat(4);
        CourseDetailsResponse courseDetail = getCourseDetail(request);
        System.out.println("courseDetail = " + JSONObject.toJSONString(courseDetail));
    }
}