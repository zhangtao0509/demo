/*
 * Copyright (c) 2014-2023 Huami, Inc. All Rights Reserved.
 */

package com.example.kafkademo;


import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileToJson {
    public static void main(String[] args) {
        String sourceFolderPath = "D:\\message_template"; // 修改为你的文件夹路径
        String targetFolderPath = "D:\\message_template_error"; // 修改为新的目录路径
        List<String> fileNameList = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        try {
            Files.createDirectories(Paths.get(targetFolderPath)); // 创建目标文件夹（如果不存在）
            Files.list(Paths.get(sourceFolderPath))
                    .filter(Files::isRegularFile)
                    .forEach(file -> {
                        try {
                            String content = new String(Files.readAllBytes(file));
                            PushMessage pushMessage = JSONObject.parseObject(content, PushMessage.class);
                            String description = pushMessage.getDescription();
                            int length = description.getBytes().length;

                            if (length > 127) {
                                String fileName = file.getFileName().toString().replaceFirst("phn_", "").replace(".ftl", "");
                                fileNameList.add(fileName);
                                map.put(fileName, description);
//                                Path targetFilePath = Paths.get(targetFolderPath, fileName);
//                                Files.copy(file, targetFilePath, StandardCopyOption.REPLACE_EXISTING);
                            }
                        } catch (IOException e) {
                            System.out.println("Error reading or copying file: " + file.getFileName());
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            System.out.println("Error accessing folders.");
            e.printStackTrace();
        }
        List<Template> jsonObjects = convertToJSON(fileNameList, map);
        excel(jsonObjects);
    }

    public static String[][] convertListToStringArray(List<Template> templateList) {
        String[][] stringArray = new String[templateList.size()][3];
        for (int i = 0; i < templateList.size(); i++) {
            Template template = templateList.get(i);
            stringArray[i][0] = template.getTypeCode();
            stringArray[i][1] = template.getLanguage();
            stringArray[i][2] = template.getDescription();
        }
        return stringArray;
    }

    public static void excel(List<Template> templateList) {
        String filePath = "output.xlsx"; // Replace with your desired file path

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Sheet1");

            // Create header row
            Row headerRow = sheet.createRow(0);
            String[] headers = {"typeCode", "language", "description"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            // Create data rows
            String[][] data = convertListToStringArray(templateList);

            for (int i = 0; i < data.length; i++) {
                Row dataRow = sheet.createRow(i + 1);
                for (int j = 0; j < data[i].length; j++) {
                    Cell cell = dataRow.createCell(j);
                    cell.setCellValue(data[i][j]);
                }
            }

            // Write the workbook to the output file
            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                workbook.write(outputStream);
            }
            System.out.println("Excel file generated successfully.");
        } catch (Exception e) {
            System.out.println("An error occurred while generating the Excel file.");
            e.printStackTrace();
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class PushMessage implements Serializable {
        private String description;
    }

    public static List<Template> convertToJSON(List<String> fileNames, Map<String, String> map) {
        List<Template> jsonList = new ArrayList<>();

        for (String fileName : fileNames) {
            String[] result = splitByThirdUnderscore(fileName);
            String des = map.get(fileName);
            Template jsonObject = new Template();
            jsonObject.setTypeCode(result[0]);
            jsonObject.setLanguage(result[1]);
            jsonObject.setDescription(des);
            jsonList.add(jsonObject);
        }
        return jsonList;
    }

    public static String[] splitByThirdUnderscore(String input) {
        String[] parts = input.split("_", 4);
        if (parts.length >= 3) {
            String part1 = parts[0] + "_" + parts[1] + "_" + parts[2];
            String part2 = parts[3];
            return new String[]{part1, part2};
        }
        return new String[0];
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Template implements Serializable {
        private String typeCode;
        private String language;
        private String description;
    }

}