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
public class CourseDetailsRequest implements Serializable {
    private static final long serialVersionUID = 5559412136361432177L;

    // Setting to determine how the response should format the country that is returned.
    // 1 (ID), 2 (Full Name), 3 (Short Name), 4 (All)
    private Integer countryFormat;

    // Setting to determine if the response should be sent with full details or basic details
    // 1 (Basic), 2 (Full)
    private Integer detailLevel;

    // Unique 12 character identifier of Course being requested (case sensitive).
    private String id_course;

    // Setting to determine how the response should format the state that is returned.
    // 1 (ID), 2 (Full Name), 3 (Short Name), 4 (All)
    private Integer stateFormat;
}