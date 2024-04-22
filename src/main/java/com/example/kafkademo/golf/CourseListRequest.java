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
public class CourseListRequest implements Serializable {
    private static final long serialVersionUID = -7906734004409159140L;
    // Whether to return only active course records, 1 for yes
    private Integer active;

    // City where the search is performed
    private String city;

    // Setting to determine how the response should format the returned country
    // 1 (ID), 2 (Full Name), 3 (Short Name), 4 (All)
    private Integer countryFormat;

    // Name used for search
    private String courseName;

    // ID_country value used for search
    private Integer id_country;

    // ID_state value used for search
    private Integer id_state;

    // 2 character ISO 639 language code
    // When provided, if courseName exists in that language in the system, it will be returned
    // ja (Japan), ko (Korea)
    private String languageCode;

    // Radius range for search (in miles)
    private String radius;

    // Position used to determine radius search, decimal degrees
    private Double referenceLatitude;

    // Position used to determine radius search, decimal degrees
    private Double referenceLongitude;

    // Setting to determine how the response should format the returned state
    // 1 (ID), 2 (Full Name), 3 (Short Name), 4 (All)
    private Integer stateFormat;

    // Zip code used for search
    private String zipcode;

    // Specified if client is requesting a specific page of results
    // 1 to 5, 1 is default
    private Integer page;

    // Determines how many results the client would like returned per page
    // 5 to 100, 20 is default
    private Integer resultsPerPage;
}