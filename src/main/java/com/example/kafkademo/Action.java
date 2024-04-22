/*
 * Copyright (c) 2014-2023 Huami, Inc. All Rights Reserved.
 */

package com.example.kafkademo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Action implements Serializable {
    /**
     * 运动类型
     */
    private Integer actionType;

    /**
     * 运动名称
     */
    private String name;
}