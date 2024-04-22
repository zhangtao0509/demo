/*
 * Copyright (c) 2014-2023 Huami, Inc. All Rights Reserved.
 */

package com.example.kafkademo;

import com.alibaba.fastjson.JSONArray;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StatCountTest {

    public static void main(String[] args) {
        String str = "[{\"type\":23,\"run_time\":1,\"calorie\":0,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":0,\"avg_heart_rate_denominator\":0,\"altitude_ascend\":0},{\"type\":16,\"run_time\":715,\"calorie\":31,\"count\":3,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":49931,\"avg_heart_rate_denominator\":715,\"altitude_ascend\":0},{\"type\":44,\"run_time\":9659,\"calorie\":500,\"count\":2,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":781117,\"avg_heart_rate_denominator\":9659,\"altitude_ascend\":0},{\"type\":1,\"run_time\":2486,\"calorie\":222,\"count\":4,\"dis\":1270,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":376146,\"avg_heart_rate_denominator\":2486,\"altitude_ascend\":3},{\"type\":1,\"run_time\":4490,\"calorie\":920,\"count\":3,\"dis\":12262,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":681004,\"avg_heart_rate_denominator\":4490,\"altitude_ascend\":47},{\"type\":140,\"run_time\":19,\"calorie\":0,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":0,\"avg_heart_rate_denominator\":0,\"altitude_ascend\":0},{\"type\":21,\"run_time\":1891,\"calorie\":99,\"count\":1,\"dis\":0,\"rope_skipping_count\":49,\"situps\":0,\"avg_heart_rate_numerator\":173972,\"avg_heart_rate_denominator\":1891,\"altitude_ascend\":0},{\"type\":6,\"run_time\":1382,\"calorie\":39,\"count\":1,\"dis\":1706,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":138200,\"avg_heart_rate_denominator\":1382,\"altitude_ascend\":9},{\"type\":97,\"run_time\":147,\"calorie\":9,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":13083,\"avg_heart_rate_denominator\":147,\"altitude_ascend\":0},{\"type\":13,\"run_time\":22976,\"calorie\":1331,\"count\":18,\"dis\":7788,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":1990950,\"avg_heart_rate_denominator\":22976,\"altitude_ascend\":55},{\"type\":21,\"run_time\":218,\"calorie\":15,\"count\":1,\"dis\":0,\"rope_skipping_count\":24,\"situps\":0,\"avg_heart_rate_numerator\":19402,\"avg_heart_rate_denominator\":218,\"altitude_ascend\":0},{\"type\":11,\"run_time\":2087,\"calorie\":0,\"count\":2,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":0,\"avg_heart_rate_denominator\":0,\"altitude_ascend\":47},{\"type\":10,\"run_time\":628,\"calorie\":38,\"count\":2,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":54812,\"avg_heart_rate_denominator\":628,\"altitude_ascend\":0},{\"type\":8,\"run_time\":11649,\"calorie\":12.789563175290823,\"count\":26,\"dis\":1915,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":77997,\"avg_heart_rate_denominator\":877,\"altitude_ascend\":0},{\"type\":16,\"run_time\":8914,\"calorie\":621,\"count\":6,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":832787,\"avg_heart_rate_denominator\":8914,\"altitude_ascend\":0},{\"type\":15,\"run_time\":7263,\"calorie\":323,\"count\":3,\"dis\":3331,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":0,\"avg_heart_rate_denominator\":0,\"altitude_ascend\":0},{\"type\":14,\"run_time\":2619,\"calorie\":31,\"count\":3,\"dis\":125,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":0,\"avg_heart_rate_denominator\":0,\"altitude_ascend\":0},{\"type\":9,\"run_time\":83768,\"calorie\":71.50194549560547,\"count\":5,\"dis\":3633,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":0,\"avg_heart_rate_denominator\":0,\"altitude_ascend\":19},{\"type\":9,\"run_time\":13621,\"calorie\":1719,\"count\":1,\"dis\":66165,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":1484689,\"avg_heart_rate_denominator\":13621,\"altitude_ascend\":587},{\"type\":21,\"run_time\":26,\"calorie\":0,\"count\":1,\"dis\":0,\"rope_skipping_count\":24,\"situps\":0,\"avg_heart_rate_numerator\":0,\"avg_heart_rate_denominator\":0,\"altitude_ascend\":0},{\"type\":16,\"run_time\":86,\"calorie\":1,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":7310,\"avg_heart_rate_denominator\":86,\"altitude_ascend\":0},{\"type\":1,\"run_time\":5502,\"calorie\":25.954619109630585,\"count\":16,\"dis\":1342,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":83844,\"avg_heart_rate_denominator\":823,\"altitude_ascend\":0},{\"type\":24,\"run_time\":16457,\"calorie\":904,\"count\":12,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":1386188,\"avg_heart_rate_denominator\":16457,\"altitude_ascend\":0},{\"type\":23,\"run_time\":5896,\"calorie\":271,\"count\":17,\"dis\":0,\"rope_skipping_count\":868,\"situps\":0,\"avg_heart_rate_numerator\":387018,\"avg_heart_rate_denominator\":4269,\"altitude_ascend\":0},{\"type\":12,\"run_time\":37,\"calorie\":1,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":2627,\"avg_heart_rate_denominator\":37,\"altitude_ascend\":0},{\"type\":6,\"run_time\":4156,\"calorie\":19.946052119135857,\"count\":7,\"dis\":681,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":72498,\"avg_heart_rate_denominator\":843,\"altitude_ascend\":1},{\"type\":22,\"run_time\":4052,\"calorie\":245,\"count\":2,\"dis\":4399,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":362695,\"avg_heart_rate_denominator\":4052,\"altitude_ascend\":13},{\"type\":21,\"run_time\":12614,\"calorie\":1135,\"count\":3,\"dis\":0,\"rope_skipping_count\":1813,\"situps\":0,\"avg_heart_rate_numerator\":1324858,\"avg_heart_rate_denominator\":12614,\"altitude_ascend\":0},{\"type\":140,\"run_time\":160,\"calorie\":9,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":13920,\"avg_heart_rate_denominator\":160,\"altitude_ascend\":0},{\"type\":21,\"run_time\":414,\"calorie\":1,\"count\":2,\"dis\":0,\"rope_skipping_count\":125,\"situps\":0,\"avg_heart_rate_numerator\":33066,\"avg_heart_rate_denominator\":414,\"altitude_ascend\":0},{\"type\":9,\"run_time\":2520,\"calorie\":149,\"count\":3,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":219530,\"avg_heart_rate_denominator\":2520,\"altitude_ascend\":0},{\"type\":131,\"run_time\":3168,\"calorie\":240,\"count\":3,\"dis\":6030,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":352050,\"avg_heart_rate_denominator\":3168,\"altitude_ascend\":72},{\"type\":144,\"run_time\":82,\"calorie\":0,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":8036,\"avg_heart_rate_denominator\":82,\"altitude_ascend\":0},{\"type\":6,\"run_time\":5820,\"calorie\":233,\"count\":1,\"dis\":840,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":424860,\"avg_heart_rate_denominator\":5820,\"altitude_ascend\":0},{\"type\":9,\"run_time\":2500,\"calorie\":77,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":227500,\"avg_heart_rate_denominator\":2500,\"altitude_ascend\":324},{\"type\":1,\"run_time\":3736,\"calorie\":255,\"count\":3,\"dis\":2317,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":354493,\"avg_heart_rate_denominator\":3736,\"altitude_ascend\":0},{\"type\":65,\"run_time\":121,\"calorie\":7,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":11616,\"avg_heart_rate_denominator\":121,\"altitude_ascend\":0},{\"type\":1,\"run_time\":24193,\"calorie\":242,\"count\":2,\"dis\":2333,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":2451159,\"avg_heart_rate_denominator\":24193,\"altitude_ascend\":211},{\"type\":7,\"run_time\":2121,\"calorie\":188,\"count\":2,\"dis\":967,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":210676,\"avg_heart_rate_denominator\":2121,\"altitude_ascend\":0},{\"type\":9,\"run_time\":1360,\"calorie\":193,\"count\":2,\"dis\":2698,\"rope_skipping_count\":14,\"situps\":0,\"avg_heart_rate_numerator\":156480,\"avg_heart_rate_denominator\":1360,\"altitude_ascend\":2},{\"type\":1,\"run_time\":6842,\"calorie\":626,\"count\":7,\"dis\":4949,\"rope_skipping_count\":33,\"situps\":0,\"avg_heart_rate_numerator\":838163,\"avg_heart_rate_denominator\":6842,\"altitude_ascend\":9},{\"type\":52,\"run_time\":459,\"calorie\":26,\"count\":2,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":39015,\"avg_heart_rate_denominator\":459,\"altitude_ascend\":0},{\"type\":6,\"run_time\":1719,\"calorie\":211,\"count\":2,\"dis\":706,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":185875,\"avg_heart_rate_denominator\":1719,\"altitude_ascend\":0},{\"type\":12,\"run_time\":413,\"calorie\":20,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":30975,\"avg_heart_rate_denominator\":413,\"altitude_ascend\":0},{\"type\":138,\"run_time\":75,\"calorie\":5,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":7725,\"avg_heart_rate_denominator\":75,\"altitude_ascend\":0},{\"type\":16,\"run_time\":1501,\"calorie\":100,\"count\":2,\"dis\":197,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":135676,\"avg_heart_rate_denominator\":1501,\"altitude_ascend\":0},{\"type\":1,\"run_time\":21,\"calorie\":0,\"count\":1,\"dis\":7,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":0,\"avg_heart_rate_denominator\":0,\"altitude_ascend\":0},{\"type\":40,\"run_time\":3629,\"calorie\":272,\"count\":5,\"dis\":1421,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":333732,\"avg_heart_rate_denominator\":3372,\"altitude_ascend\":0},{\"type\":46,\"run_time\":7220,\"calorie\":372,\"count\":7,\"dis\":30828,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":622039,\"avg_heart_rate_denominator\":7220,\"altitude_ascend\":184},{\"type\":43,\"run_time\":47,\"calorie\":2,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":3807,\"avg_heart_rate_denominator\":47,\"altitude_ascend\":0},{\"type\":163,\"run_time\":56,\"calorie\":3,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":5040,\"avg_heart_rate_denominator\":56,\"altitude_ascend\":0},{\"type\":130,\"run_time\":28,\"calorie\":1,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":2100,\"avg_heart_rate_denominator\":28,\"altitude_ascend\":0},{\"type\":131,\"run_time\":11465,\"calorie\":393,\"count\":10,\"dis\":4286,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":627501,\"avg_heart_rate_denominator\":7191,\"altitude_ascend\":47},{\"type\":132,\"run_time\":5356,\"calorie\":397,\"count\":5,\"dis\":13123,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":503479,\"avg_heart_rate_denominator\":5356,\"altitude_ascend\":56},{\"type\":110,\"run_time\":233,\"calorie\":24,\"count\":1,\"dis\":369,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":27261,\"avg_heart_rate_denominator\":233,\"altitude_ascend\":8},{\"type\":111,\"run_time\":4061,\"calorie\":151,\"count\":3,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":393617,\"avg_heart_rate_denominator\":4061,\"altitude_ascend\":0},{\"type\":1,\"run_time\":60336,\"calorie\":8036,\"count\":22,\"dis\":121741,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":7926705,\"avg_heart_rate_denominator\":55940,\"altitude_ascend\":212},{\"type\":1001,\"run_time\":2500,\"calorie\":127,\"count\":1,\"dis\":3191,\"rope_skipping_count\":4,\"situps\":0,\"avg_heart_rate_numerator\":300000,\"avg_heart_rate_denominator\":2500,\"altitude_ascend\":14},{\"type\":109,\"run_time\":503,\"calorie\":41,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":50300,\"avg_heart_rate_denominator\":503,\"altitude_ascend\":0},{\"type\":6,\"run_time\":15573,\"calorie\":381,\"count\":10,\"dis\":8633,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":850117,\"avg_heart_rate_denominator\":8074,\"altitude_ascend\":86},{\"type\":52,\"run_time\":9978,\"calorie\":455,\"count\":6,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":803637,\"avg_heart_rate_denominator\":9978,\"altitude_ascend\":0},{\"type\":7,\"run_time\":4745,\"calorie\":88,\"count\":1,\"dis\":24706,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":474500,\"avg_heart_rate_denominator\":4745,\"altitude_ascend\":13},{\"type\":172,\"run_time\":158,\"calorie\":0,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":10112,\"avg_heart_rate_denominator\":158,\"altitude_ascend\":0},{\"type\":126,\"run_time\":2942,\"calorie\":224,\"count\":6,\"dis\":2440,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":288339,\"avg_heart_rate_denominator\":2942,\"altitude_ascend\":10},{\"type\":127,\"run_time\":2691,\"calorie\":192,\"count\":5,\"dis\":6297,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":251701,\"avg_heart_rate_denominator\":2691,\"altitude_ascend\":19},{\"type\":128,\"run_time\":440,\"calorie\":45,\"count\":2,\"dis\":482,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":50556,\"avg_heart_rate_denominator\":440,\"altitude_ascend\":0},{\"type\":25,\"run_time\":4120,\"calorie\":196,\"count\":12,\"dis\":6540,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":0,\"avg_heart_rate_denominator\":0,\"altitude_ascend\":0},{\"type\":129,\"run_time\":254,\"calorie\":15,\"count\":2,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":22183,\"avg_heart_rate_denominator\":254,\"altitude_ascend\":0},{\"type\":157,\"run_time\":166,\"calorie\":11,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":17762,\"avg_heart_rate_denominator\":166,\"altitude_ascend\":0},{\"type\":125,\"run_time\":361,\"calorie\":39,\"count\":1,\"dis\":311,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":42598,\"avg_heart_rate_denominator\":361,\"altitude_ascend\":0},{\"type\":1015,\"run_time\":370,\"calorie\":72,\"count\":2,\"dis\":468,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":0,\"avg_heart_rate_denominator\":0,\"altitude_ascend\":0},{\"type\":159,\"run_time\":368,\"calorie\":13,\"count\":2,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":30433,\"avg_heart_rate_denominator\":368,\"altitude_ascend\":0},{\"type\":126,\"run_time\":2068,\"calorie\":47,\"count\":2,\"dis\":779,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":198568,\"avg_heart_rate_denominator\":2068,\"altitude_ascend\":38},{\"type\":120,\"run_time\":569,\"calorie\":33,\"count\":2,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":48149,\"avg_heart_rate_denominator\":569,\"altitude_ascend\":0},{\"type\":121,\"run_time\":4293,\"calorie\":269,\"count\":3,\"dis\":2641,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":340308,\"avg_heart_rate_denominator\":3447,\"altitude_ascend\":0},{\"type\":122,\"run_time\":244,\"calorie\":13,\"count\":2,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":19518,\"avg_heart_rate_denominator\":244,\"altitude_ascend\":0},{\"type\":123,\"run_time\":8548,\"calorie\":553,\"count\":6,\"dis\":3564,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":752110,\"avg_heart_rate_denominator\":8548,\"altitude_ascend\":0},{\"type\":125,\"run_time\":2053,\"calorie\":125,\"count\":5,\"dis\":1261,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":178200,\"avg_heart_rate_denominator\":2053,\"altitude_ascend\":4},{\"type\":6,\"run_time\":15244,\"calorie\":7,\"count\":1,\"dis\":293,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":899396,\"avg_heart_rate_denominator\":15244,\"altitude_ascend\":0},{\"type\":66,\"run_time\":1541,\"calorie\":121,\"count\":7,\"dis\":2723,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":150870,\"avg_heart_rate_denominator\":1417,\"altitude_ascend\":0},{\"type\":160,\"run_time\":96,\"calorie\":7,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":9312,\"avg_heart_rate_denominator\":96,\"altitude_ascend\":0},{\"type\":161,\"run_time\":54,\"calorie\":3,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":4482,\"avg_heart_rate_denominator\":54,\"altitude_ascend\":0},{\"type\":115,\"run_time\":3132,\"calorie\":183,\"count\":4,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":261751,\"avg_heart_rate_denominator\":3132,\"altitude_ascend\":0},{\"type\":116,\"run_time\":372,\"calorie\":22,\"count\":2,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":31512,\"avg_heart_rate_denominator\":372,\"altitude_ascend\":0},{\"type\":117,\"run_time\":181,\"calorie\":10,\"count\":2,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":15450,\"avg_heart_rate_denominator\":181,\"altitude_ascend\":0},{\"type\":16,\"run_time\":485,\"calorie\":10,\"count\":2,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":35918,\"avg_heart_rate_denominator\":485,\"altitude_ascend\":0},{\"type\":69,\"run_time\":379,\"calorie\":31,\"count\":1,\"dis\":450,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":37521,\"avg_heart_rate_denominator\":379,\"altitude_ascend\":0},{\"type\":118,\"run_time\":431,\"calorie\":31,\"count\":2,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":40439,\"avg_heart_rate_denominator\":431,\"altitude_ascend\":0},{\"type\":119,\"run_time\":594,\"calorie\":30,\"count\":2,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":46200,\"avg_heart_rate_denominator\":594,\"altitude_ascend\":0},{\"type\":24,\"run_time\":908,\"calorie\":82,\"count\":4,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":89627,\"avg_heart_rate_denominator\":908,\"altitude_ascend\":0},{\"type\":189,\"run_time\":104,\"calorie\":0,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":0,\"avg_heart_rate_denominator\":0,\"altitude_ascend\":0},{\"type\":12,\"run_time\":320,\"calorie\":9,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":25280,\"avg_heart_rate_denominator\":320,\"altitude_ascend\":0},{\"type\":1,\"run_time\":2490,\"calorie\":67,\"count\":1,\"dis\":1247,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":241530,\"avg_heart_rate_denominator\":2490,\"altitude_ascend\":0},{\"type\":1,\"run_time\":3700,\"calorie\":309,\"count\":3,\"dis\":4396,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":378627,\"avg_heart_rate_denominator\":3700,\"altitude_ascend\":92},{\"type\":110,\"run_time\":4605,\"calorie\":77,\"count\":4,\"dis\":7076,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":339970,\"avg_heart_rate_denominator\":3861,\"altitude_ascend\":39},{\"type\":111,\"run_time\":195,\"calorie\":11,\"count\":2,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":16835,\"avg_heart_rate_denominator\":195,\"altitude_ascend\":0},{\"type\":112,\"run_time\":2334,\"calorie\":191,\"count\":2,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":235506,\"avg_heart_rate_denominator\":2334,\"altitude_ascend\":0},{\"type\":113,\"run_time\":747,\"calorie\":56,\"count\":3,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":74425,\"avg_heart_rate_denominator\":747,\"altitude_ascend\":0},{\"type\":114,\"run_time\":182,\"calorie\":16,\"count\":2,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":19034,\"avg_heart_rate_denominator\":182,\"altitude_ascend\":0},{\"type\":10,\"run_time\":1429,\"calorie\":26,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":100030,\"avg_heart_rate_denominator\":1429,\"altitude_ascend\":0},{\"type\":71,\"run_time\":2373,\"calorie\":172,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":223062,\"avg_heart_rate_denominator\":2373,\"altitude_ascend\":0},{\"type\":70,\"run_time\":187,\"calorie\":18,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":21692,\"avg_heart_rate_denominator\":187,\"altitude_ascend\":0},{\"type\":75,\"run_time\":2145,\"calorie\":87,\"count\":2,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":180487,\"avg_heart_rate_denominator\":2145,\"altitude_ascend\":0},{\"type\":73,\"run_time\":5093,\"calorie\":283,\"count\":3,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":413026,\"avg_heart_rate_denominator\":5093,\"altitude_ascend\":0},{\"type\":22,\"run_time\":2491,\"calorie\":184,\"count\":1,\"dis\":1617,\"rope_skipping_count\":1,\"situps\":0,\"avg_heart_rate_numerator\":234154,\"avg_heart_rate_denominator\":2491,\"altitude_ascend\":2},{\"type\":21,\"run_time\":221,\"calorie\":15,\"count\":2,\"dis\":0,\"rope_skipping_count\":218,\"situps\":0,\"avg_heart_rate_numerator\":24076,\"avg_heart_rate_denominator\":221,\"altitude_ascend\":0},{\"type\":191,\"run_time\":1085,\"calorie\":63,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":94395,\"avg_heart_rate_denominator\":1085,\"altitude_ascend\":0},{\"type\":8,\"run_time\":665,\"calorie\":28,\"count\":2,\"dis\":460,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":37014,\"avg_heart_rate_denominator\":398,\"altitude_ascend\":0},{\"type\":22,\"run_time\":983,\"calorie\":89,\"count\":1,\"dis\":1326,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":110096,\"avg_heart_rate_denominator\":983,\"altitude_ascend\":11},{\"type\":17,\"run_time\":3034,\"calorie\":138,\"count\":3,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":266383,\"avg_heart_rate_denominator\":3034,\"altitude_ascend\":0},{\"type\":173,\"run_time\":41,\"calorie\":0,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":2337,\"avg_heart_rate_denominator\":41,\"altitude_ascend\":0},{\"type\":105,\"run_time\":9167,\"calorie\":84,\"count\":7,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":183197,\"avg_heart_rate_denominator\":2333,\"altitude_ascend\":463},{\"type\":106,\"run_time\":655,\"calorie\":37,\"count\":2,\"dis\":188,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":53443,\"avg_heart_rate_denominator\":655,\"altitude_ascend\":0},{\"type\":176,\"run_time\":44,\"calorie\":0,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":0,\"avg_heart_rate_denominator\":0,\"altitude_ascend\":0},{\"type\":108,\"run_time\":151,\"calorie\":11,\"count\":2,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":16800,\"avg_heart_rate_denominator\":151,\"altitude_ascend\":0},{\"type\":177,\"run_time\":63,\"calorie\":0,\"count\":1,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":0,\"avg_heart_rate_denominator\":0,\"altitude_ascend\":0},{\"type\":109,\"run_time\":293,\"calorie\":14,\"count\":3,\"dis\":0,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":25442,\"avg_heart_rate_denominator\":293,\"altitude_ascend\":0},{\"type\":15,\"run_time\":1472,\"calorie\":72,\"count\":1,\"dis\":1015,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":0,\"avg_heart_rate_denominator\":0,\"altitude_ascend\":0},{\"type\":2002,\"run_time\":12754,\"calorie\":675,\"count\":5,\"dis\":11754,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":1469150,\"avg_heart_rate_denominator\":12754,\"altitude_ascend\":0},{\"type\":2001,\"run_time\":26444,\"calorie\":1249,\"count\":4,\"dis\":15151,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":2693957,\"avg_heart_rate_denominator\":26444,\"altitude_ascend\":0},{\"type\":11,\"run_time\":17057,\"calorie\":1126,\"count\":2,\"dis\":4101,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":1796418,\"avg_heart_rate_denominator\":17057,\"altitude_ascend\":106},{\"type\":8,\"run_time\":338,\"calorie\":5,\"count\":1,\"dis\":70,\"rope_skipping_count\":0,\"situps\":0,\"avg_heart_rate_numerator\":28730,\"avg_heart_rate_denominator\":338,\"altitude_ascend\":0}]";
        List<StatCount> statCounts = JSONArray.parseArray(str, StatCount.class);
        Map<Integer, List<StatCount>> map = statCounts.stream().collect(Collectors.groupingBy(StatCount::getType));
        Map<Integer, List<StatCount>> sortedMap = new TreeMap<>(map);
        for (Integer type : sortedMap.keySet()) {
            List<StatCount> statCounts1 = map.get(type);
            System.out.print("type = " + type + "  ");
            int sum = 0;
            for (StatCount statCount : statCounts1) {
                sum += statCount.getCount();
            }
            System.out.println("count = " + sum);
        }
    }
}