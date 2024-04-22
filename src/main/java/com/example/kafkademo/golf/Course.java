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
public class Course implements Serializable {
    private static final long serialVersionUID = -7171853682971278L;

    // Determines if course is active. 0 (No), 1 (Yes)
    private Integer active;

    // Unique identifier for the course
    private String id_course;

    // Address of Course
    private String address1;

    // Address of Course
    private String address2;

    // City where Course is located
    private String city;

    // ID of the country
    private Integer id_country;

    // Full name of country
    private String countryFull;

    // Short name of country
    private String countryShort;

    // Course's name
    private String courseName;

    // Distance from reference position to course (in miles)
    private Double distance;

    // Latitude value for the clubhouse
    private Double latitude;

    // Longitude value for the clubhouse
    private Double longitude;

    // Number of holes for the course
    private Integer layoutHoles;

    // Number of holes for the entire facility
    private Integer layoutTotalHoles;

    // Label name for course layout. Ex. 2-18 Hole
    private String layoutName;

    // Determines if GPS is available for the course. 0 (No), 1 (Yes)
    private Integer gpsAvailable;

    // Determines if Scorecard is available for the course. 0 (No), 1 (Yes)
    private Integer scorecardAvailable;

    // Determines if vector image is available for the course. 0 (No), 1 (Yes)
    private Integer vectorAvailable;

    // Determines if terrain data is available for the course. 0 (No), 1 (Yes)
    private Integer elevationAvailable;

    // Recommend rating value of the course. Possible values from 0.0 to 5.0
    private Double recommendRating;

    // Condition rating value of the course. Possible values from 0.0 to 5.0
    private Double conditionRating;

    // State where Course is located if not in State drop-down
    private String otherState;

    // ID of the state
    private Integer id_state;

    // Full name of state
    private String stateFull;

    // Short name of state
    private String stateShort;

    // URI for the photo thumbnail of the course
    private String thumbnailImage;
}
