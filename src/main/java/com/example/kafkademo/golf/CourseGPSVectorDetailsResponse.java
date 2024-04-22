/*
 * Copyright (c) 2014-2024 Huami, Inc. All Rights Reserved.
 */

package com.example.kafkademo.golf;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseGPSVectorDetailsResponse implements Serializable {
    private static final long serialVersionUID = -1994450383335566870L;

    // Acknowledges successful request
    // 1 (Success), -1 (Error)
    private Integer Status;

    // Specifies error message if received
    private String ErrorMessage;

    // JSON Object of GPS information for the course
    private JSONObject vectorGPSObject;


}