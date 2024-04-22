/*
 * Copyright (c) 2014-2023 Huami, Inc. All Rights Reserved.
 */

package com.example.kafkademo;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExcelTransform1 {
    public static void main(String[] args) {
        File templateFile = new File("D:\\project\\kafkaDemo\\src\\main\\resources\\v20220406.xlsx");
        produceExcelByTemplate(templateFile, 32);
    }


    /**
     * 根据模板文件产生Excel文件
     *
     * @param templateFile 模板文件
     */
    private static void produceExcelByTemplate(File templateFile, int m) {
        //===========================读取测试=====================================
        ExcelReader excelReader = ExcelUtil.getReader(templateFile, 0);
        //读取数据，按照行列方式读取所有数据
        List<List<Object>> rowObjects = excelReader.read();
        List<Map<Object, Object>> objMapList = new ArrayList<>();
        List<JSONModel> jsonModelList = new ArrayList<>();
        System.out.println("----------------------------------------------------------------------------------------------");
        for (int i = 1; i < rowObjects.size(); i++) {
            List<Object> objects = rowObjects.get(i);
            System.out.println(objects.get(0));
//            System.out.println(objects.get(8) + ": '" + objects.get(1)+"',");
        }
        System.out.println("----------------------------------------------------------------------------------------------");
    }
}