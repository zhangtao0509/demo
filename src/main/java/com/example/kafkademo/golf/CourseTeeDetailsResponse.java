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
public class CourseTeeDetailsResponse implements Serializable {
    private static final long serialVersionUID = 4234941034661645471L;

    // Acknowledges successful request
    // 1 (Success), -1 (Error)
    private Integer Status;

    // Specifies error message if received
    private String ErrorMessage;

    // Array of simple information for tees on the course
    private List<TeeInfo> teesList;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class TeeInfo {
        /*--------------------------------------------  detailLevel=1、detailLevel=2 ---------------------------------------*/
        // Indicates if tee uses men's or women's par (men, wmn)
        private String gender;

        // Men's course rating
        private Double ratingMen;

        // Women's course rating
        private Double ratingWomen;

        // Men's course slope
        private Integer slopeMen;

        // Women's course slope
        private Integer slopeWomen;

        // Name of tee
        private String teeName;

        // Name of color associated with the tee
        private String teeColorName;

        // Hex color value - no color is returned as FF00FF
        private String teeColorValue;

        // Total yards for the tee
        private Integer ydsTotal;
        /*--------------------------------------------  detailLevel=1、detailLevel=2 ---------------------------------------*/

        /*--------------------------------------------  detailLevel=2 ---------------------------------------*/
        // Total of values for holes 1 to 9
        private String yds1to9;

        // Total of values for holes 10 to 18
        private String yds10to18;

        // Total of values for holes 1 to 18
        private String yds1to18;

        // JSON array of integers in order from yds1 to yds18
        private List<Integer> ydsHole;
        /*--------------------------------------------  detailLevel=2 ---------------------------------------*/
    }
}