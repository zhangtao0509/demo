/*
 * Copyright (c) 2014-2024 Huami, Inc. All Rights Reserved.
 */

package com.example.kafkademo.golf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseListResponse implements Serializable {
    private static final long serialVersionUID = 4180957269083019186L;

    //Page number of results returned
    private Integer page;

    //Total number of pages (as defined by resultsPerPage in the request) for the criteria submitted.
    private Integer totalpages;

    //Total number of courses for the criteria submitted.
    private Integer totalCourses;

    //List of data returned with following elements for each course returned.
    private List<Course> courseList;

    //Acknowledges successful request：1 (Success), -1 (Error)
    private Integer Status;

    //Specifies error message if received
    private String ErrorMessage;
}