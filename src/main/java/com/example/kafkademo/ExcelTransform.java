/*
 * Copyright (c) 2014-2023 Huami, Inc. All Rights Reserved.
 */

package com.example.kafkademo;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExcelTransform {
    public static void main(String[] args) {
        File templateFile = new File("D:\\project\\kafkaDemo\\src\\main\\resources\\transform.xls");
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
        int columnCount = excelReader.getColumnCount();
        int l = 1;
        int i = 2;
        while (i < columnCount - 1) {
            Map<Object, Object> map = new HashMap<>();
            while (l < rowObjects.size()) {
                map.put(excelReader.readCellValue(34, l), excelReader.readCellValue(i, l));
                l++;
            }
            objMapList.add(map);
            i++;
            l = 1;
        }
        String json = readJsonFile("example.json");
        ExerciseName exerciseName = JSONObject.parseObject(json, ExerciseName.class);
        Map<String, Action> actionMap = exerciseName.getActions().stream().collect(Collectors.toMap(Action::getName, Function.identity()));
        for (int j = m; j < objMapList.size(); j++) {
            ExerciseName buildExerciseName = new ExerciseName();
            Map<Object, Object> map = objMapList.get(j);
            List<Action> actions = new ArrayList<>();
            for (Object object : map.keySet()) {
                Action action = actionMap.get((String) object);
                String str = (String) map.get(object);
                Action newAction = new Action();
                newAction.setActionType(action.getActionType());
                newAction.setName(str);
                actions.add(newAction);
            }
            CollectionUtil.sort(actions, Comparator.comparing(Action::getActionType));
            buildExerciseName.setActions(actions);
            System.out.println(JSONObject.toJSONString(buildExerciseName));
            break;
        }
        //关闭
        excelReader.close();
    }

    public static String readJsonFile(String fileName) {
        FileReader fileReader = null;
        Reader reader = null;
        try {
            File jsonFile = ResourceUtils.getFile("classpath:" + fileName);
            fileReader = new FileReader(jsonFile);
            reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            String jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}