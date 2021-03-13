/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.data

import com.example.androiddevchallenge.R

data class Ticker(
    val ticker: String,
    val name: String,
    val last: String,
    val change: String,
    val isGreen: Boolean,
    val img: Int,
)

val tickerList = listOf(
    Ticker("ALK", "Alaska Air Group inc.", "$7,918", "-0.54%", false, R.drawable.ic_home_alk),
    Ticker("BA", "Boeing Co.", "$1,293", "+4.18%", true, R.drawable.ic_home_ba),
    Ticker("DAL", "Delta Airlines Inc.", "$893.50", "-0.54%", false, R.drawable.ic_home_dal),
    Ticker("EXPE", "Expedia Group Inc.", "$12,301", "+2.51%", true, R.drawable.ic_home_exp),
    Ticker("EADSY", "Airbus SE", "$12,301", "+1.38%", true, R.drawable.ic_home_eadsy),
    Ticker("JBLU", "Jetblue Airways Corp.", "$8,521", "+1.56%", true, R.drawable.ic_home_jblu),
    Ticker("MAR", "Mariott International Inc.", "$521", "+275%", true, R.drawable.ic_home_mar),
    Ticker("CCL", "Carnival Crop", "$5,481", "+0.14%", true, R.drawable.ic_home_ccl),
    Ticker("RCL", "Royal Caribbean Cruises", "$9,184", "+1.69%", true, R.drawable.ic_home_rcl),
    Ticker("TRVL", "Travelocity Inc.", "$654", "+3.23%", true, R.drawable.ic_home_trvl),
)
