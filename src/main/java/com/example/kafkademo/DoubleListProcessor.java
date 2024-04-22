/*
 * Copyright (c) 2014-2023 Huami, Inc. All Rights Reserved.
 */

package com.example.kafkademo;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoubleListProcessor {

    public static void main(String[] args) {
//        List<Double> doubles = Arrays.asList(-32768.0d,-32768.0d,-32768.0d,-32768.0d,5d,4d,6d,8d);
//        List<Double> doubleList = processList(doubles);
//        System.out.println("doubleList = " + JSONObject.toJSONString(doubleList));
        List<Integer> strings = Arrays.asList(12, 13);
        boolean contains = strings.contains(1);
        System.out.println("contains = " + contains);
    }

    public static List<Double> processList(List<Double> inputList) {
        List<Double> resultList = new ArrayList<>();

        for (int i = 0; i < inputList.size(); i++) {
            double value = inputList.get(i);
            if (value == -32768.0) {
                double newValue = findReplacementValue(inputList, i);
                resultList.add(newValue);
            } else {
                resultList.add(value);
            }
        }

        return resultList;
    }

    private static double findReplacementValue(List<Double> list, int index) {
        int prevIndex = findPrevNonFillIndex(list, index);
        int nextIndex = findNextNonFillIndex(list, index);

        if (prevIndex != -1 && nextIndex != -1) {
            if (index - prevIndex <= nextIndex - index) {
                return list.get(prevIndex);
            } else {
                return list.get(nextIndex);
            }
        } else if (prevIndex != -1) {
            return list.get(prevIndex);
        } else if (nextIndex != -1) {
            return list.get(nextIndex);
        } else {
            return -32768.0; // If no valid replacement is found
        }
    }

    private static int findPrevNonFillIndex(List<Double> list, int index) {
        for (int i = index - 1; i >= 0; i--) {
            if (list.get(i) != -32768.0) {
                return i;
            }
        }
        return -1; // If no valid value is found
    }

    private static int findNextNonFillIndex(List<Double> list, int index) {
        for (int i = index + 1; i < list.size(); i++) {
            if (list.get(i) != -32768.0) {
                return i;
            }
        }
        return -1; // If no valid value is found
    }

}
