/*
 * Copyright (c) 2014-2022 Huami, Inc. All Rights Reserved.
 */

package com.example.kafkademo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseName implements Serializable {

    private List<Action> actions;
}