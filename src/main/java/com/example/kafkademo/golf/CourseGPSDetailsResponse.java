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
public class CourseGPSDetailsResponse implements Serializable {
    private static final long serialVersionUID = -2841859630436399932L;

    // Acknowledges successful request
    // 1 (Success), -1 (Error)
    private Integer Status;

    // Specifies error message if received
    private String ErrorMessage;

    // Array of GPS information for each hole (1 - 18)
    private List<GPSData> GPSList;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class GPSData implements Serializable {
        // Hole Number
        private Integer holeNumber;

        // Latitude of front point
        private Double frontLat;

        // Longitude of front point
        private Double frontLon;

        // Latitude of center point
        private Double centerLat;

        // Longitude of center point
        private Double centerLon;

        // Latitude of back point
        private Double backLat;

        // Longitude of back point
        private Double backLon;

        // Latitude of tee 1 point
        private Double teeLat1;

        // Longitude of tee 1 point
        private Double teeLon1;

        // Latitude of tee 2 point
        private Double teeLat2;

        // Longitude of tee 2 point
        private Double teeLon2;

        // Latitude of tee 3 point
        private Double teeLat3;

        // Longitude of tee 3 point
        private Double teeLon3;

        // Latitude of tee 4 point
        private Double teeLat4;

        // Longitude of tee 4 point
        private Double teeLon4;

        // Latitude of tee 5 point
        private Double teeLat5;

        // Longitude of tee 5 point
        private Double teeLon5;

        // Latitude of custom 1 point
        private Double customLat1;

        // Longitude of custom 1 point
        private Double customLon1;

        // Name of custom point 1
        private String customName1;

        // Description of custom point 1
        private String customDesc1;

        // Latitude of custom 2 point
        private Double customLat2;

        // Longitude of custom 2 point
        private Double customLon2;

        // Name of custom point 2
        private String customName2;

        // Description of custom point 2
        private String customDesc2;

        // Latitude of custom 3 point
        private Double customLat3;

        // Longitude of custom 3 point
        private Double customLon3;

        // Name of custom point 3
        private String customName3;

        // Description of custom point 3
        private String customDesc3;

        // Latitude of custom 4 point
        private Double customLat4;

        // Longitude of custom 4 point
        private Double customLon4;

        // Name of custom point 4
        private String customName4;

        // Description of custom point 4
        private String customDesc4;
    }
}