/*
 * Copyright (c) 2014-2024 Huami, Inc. All Rights Reserved.
 */

package com.example.kafkademo.golf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDetailsResponse implements Serializable {
    private static final long serialVersionUID = 6692351144324085653L;

    /*--------------------------------------------  detailLevel=1、detailLevel=2 ---------------------------------------*/
    // Acknowledges successful request
    // 1 (Success), -1 (Error)
    private Integer Status;

    // Specifies error message if received
    private String ErrorMessage;

    // Determines if course is active
    // 0 (No), 1 (Yes)
    private Integer active;

    // Address of Course
    private String address1;

    // Address of Course
    private String address2;

    // City where Course is located
    private String city;

    // Class type of golf course
    // public, private, semi-private, military, resort
    private String courseClass;

    // ID of the country
    private Integer id_country;

    // Full name of country
    private String countryFull;

    // Short name of country
    private String countryShort;

    // Course's name
    private String courseName;

    // Dress code for course
    // nodenim, denimok
    private String dressCode;

    // Course's email address
    private String email;

    // Determines if GPS is available for the course
    // 0 (No), 1 (Yes)
    private Integer gpsAvailable;

    // URI for the photo of the course
    private String image;

    // Number of holes for the course
    private Integer layoutHoles;

    // Total number of holes for all courses at the location
    private Integer layoutTotalHoles;

    // Name of the course layout type
    private String layoutName;

    // State where Course is located if not in State drop-down
    private String otherState;

    // Course phone number
    private String phone;

    // Determines if course is open all year or seasonal
    // 0 (Open All Year), 1 (Seasonal)
    private Integer seasonal;

    // ID of the state
    private Integer id_state;

    // Full name of state
    private String stateFull;

    // Short name of state
    private String stateShort;

    // URI for the photo thumbnail of the course
    private String thumbnailImage;

    // Course website
    private String url;

    // Zip code where Course is located
    private String zipcode;
    /*--------------------------------------------  detailLevel=1、detailLevel=2 ---------------------------------------*/

    /*--------------------------------------------  detailLevel=2 --------------------------------------------- */
    // Date and Time the course was added to the system (yyyy-mm-dd hh:mm:ss)
    private LocalDateTime courseCreated;

    // Date and Time the course was deactivated from the system (yyyy-mm-dd hh:mm:ss)
    private LocalDateTime courseDeactivated;

    // Date and Time the course was last modified the system (yyyy-mm-dd hh:mm:ss)
    private LocalDateTime courseModified;

    // Day of the week that course is closed (Sun, Mon, Tue, Wed, Thu, Fri, Sat)
    private String dayClosed;

    // Name of course director
    private String directorName;

    // Course fax number
    private String fax;

    // Determines if course supports groups of 5 (0 (No), 1 (Yes))
    private Integer fivesome;

    // Date and Time the gps was last modified (yyyy-mm-dd hh:mm:ss)
    private LocalDateTime gpsModified;

    // Price for a weekend 9 hole round
    private Double weekend9;

    // Price for a weekend 18 hole round
    private Double weekend18;

    // Price for a weekday 9 hole round
    private Double weekday9;

    // Price for a weekday 18 hole round
    private Double weekday18;

    // Price for a twilight round
    private Double twilight;

    // Name of course professional
    private String professionalName;

    // Time pro shop opens (hh:mm:ss)
    private LocalTime proShopOpen;

    // Time pro shop closes (hh:mm:ss)
    private LocalTime proShopClose;

    // Determines if scorecard is available for the course (0 (No), 1 (Yes))
    private Integer scorecardAvailable;

    // Date and Time the scorecard was last modified (yyyy-mm-dd hh:mm:ss)
    private LocalDateTime scorecardModified;

    // Month that season ends at course (1 (January), 2 (February), ...)
    private Integer seasonEnd;

    // Month that season starts at course (1 (January), 2 (February), ...)
    private Integer seasonStart;

    // Name of course superintendent
    private String superintendentName;

    // Download available for hardware device (0 (No), 1 (Yes))
    private Integer syncOutputAvailable;

    // Date and Time the sync output was modified (yyyy-mm-dd hh:mm:ss)
    private LocalDateTime syncOutputModified;

    // Vector data is available for the course (0 (No), 1 (Yes))
    private Integer vectorAvailable;

    // Date and Time the vector was modified (yyyy-mm-dd hh:mm:ss)
    private LocalDateTime vectorModified;
    /*--------------------------------------------  detailLevel=2 --------------------------------------------- */
}