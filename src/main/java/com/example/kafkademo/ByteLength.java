/*
 * Copyright (c) 2014-2023 Huami, Inc. All Rights Reserved.
 */

package com.example.kafkademo;

public class ByteLength {
    public static void main(String[] args) {
        String str = "لم تكن جودة نومك جيدة الليلة الماضية. إذا كنت تشعر بالتعب، فلا تضغط على نفسك.";
        int length = str.getBytes().length;
        System.out.println("length = " + length);
    }
}