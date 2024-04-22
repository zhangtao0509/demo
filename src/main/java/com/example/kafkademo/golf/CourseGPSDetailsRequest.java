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
public class CourseGPSDetailsRequest implements Serializable {
    private static final long serialVersionUID = -6669326938568431202L;

    // Unique 12 character identifier of the Course being requested
    private String id_course;
}