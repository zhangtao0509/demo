/*
 * Copyright (c) 2014-2024 Huami, Inc. All Rights Reserved.
 */

package com.example.kafkademo.golf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseTeeDetailsRequest implements Serializable {
    private static final long serialVersionUID = 1084959320738914399L;

    // Setting to determine if the response should be sent with full details or simple details
    // 1 (Simple), 2 (Full)
    private Integer detailLevel;

    // Unique 12 character identifier of the Course being requested
    private String id_course;
}