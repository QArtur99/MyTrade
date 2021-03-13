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
package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.data.Ticker
import com.example.androiddevchallenge.ui.data.marketList
import com.example.androiddevchallenge.ui.data.tickerList
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.ui.theme.transparent
import java.util.Locale

@Composable
fun Home(isDarkTheme: Boolean, navController: NavController) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.background)
    ) {
        ButtonRow()
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .height(32.dp)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.align(Alignment.BottomCenter),
                text = "Balance",
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.subtitle1,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.align(Alignment.BottomCenter),
                text = "$73,589.01",
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.h1,
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.align(Alignment.BottomCenter),
                text = "+412.35 today",
                color = MaterialTheme.colors.secondary,
                style = MaterialTheme.typography.subtitle1,
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { /*TODO*/ },
            shape = shapes.medium,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primary
            ),
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth()
                .height(48.dp),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp,
                pressedElevation = 0.dp,
                disabledElevation = 0.dp,
            ),
        ) {
            Text(
                text = "TRANSACT".toUpperCase(Locale.ROOT),
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.button,
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .height(40.dp)
                .horizontalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.width(16.dp))
            for (market in marketList) {
                MarketRow(navController, market.name, market.isArrow)
            }
            Spacer(modifier = Modifier.width(16.dp))
        }
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_home_illos),
            contentDescription = "welcome background",
            contentScale = ContentScale.FillBounds,
        )
        Spacer(modifier = Modifier.height(32.dp))
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colors.surface)
        ) {
            Row(
                modifier = Modifier.height(40.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Positions",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onSurface,
                    style = MaterialTheme.typography.subtitle1,
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            for (ticker in tickerList) {
                Divider(
                    modifier = Modifier
                        .alpha(0.5f)
                        .padding(start = 16.dp, end = 16.dp),
                    color = MaterialTheme.colors.onSurface
                )
                TickerRow(navController, ticker)
            }
            Spacer(modifier = Modifier.height(48.dp))
        }
    }
}

@Composable
private fun TickerRow(navController: NavController, ticker: Ticker) {

    val col = if (ticker.isGreen) {
        MaterialTheme.colors.secondary
    } else {
        MaterialTheme.colors.onSecondary
    }

    Row(
        modifier = Modifier
            .height(56.dp)
            .padding(start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Row(
                modifier = Modifier.height(24.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    modifier = Modifier.width(64.dp),
                    text = ticker.last,
                    color = MaterialTheme.colors.onSurface,
                    style = MaterialTheme.typography.body1,
                )
                Text(
                    text = ticker.ticker,
                    color = MaterialTheme.colors.onSurface,
                    style = MaterialTheme.typography.h3,
                )
            }
            Row(
                modifier = Modifier.height(16.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    modifier = Modifier.width(64.dp),
                    text = ticker.change,
                    color = col,
                    style = MaterialTheme.typography.body1,
                )
                Text(
                    text = ticker.name,
                    color = MaterialTheme.colors.onSurface,
                    style = MaterialTheme.typography.body1,
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        Icon(
            modifier = Modifier.align(Alignment.CenterVertically),
            imageVector = ImageVector.vectorResource(id = ticker.img),
            contentDescription = "chart",
            tint = col
        )
    }
}

@Composable
private fun MarketRow(navController: NavController, text: String, isArrow: Boolean) {
    OutlinedButton(
        onClick = {
            /*TODO*/
        },
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(1.dp, MaterialTheme.colors.onBackground),
        modifier = Modifier
            .fillMaxHeight(),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp,
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = transparent
        ),
    ) {
        Row {
            Text(
                text = text,
                modifier = Modifier.align(Alignment.CenterVertically),
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.body1,
            )
            if (isArrow) {
                Icon(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_expand_more_24),
                    contentDescription = "spinner",
                    tint = MaterialTheme.colors.onBackground
                )
            }
        }
    }
    Spacer(modifier = Modifier.width(8.dp))
}

@Composable
private fun ButtonRow() {
    Row(
        modifier = Modifier.height(88.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.background
            ),
            modifier = Modifier.weight(1f),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp,
                pressedElevation = 0.dp,
                disabledElevation = 0.dp,
            ),
            contentPadding = PaddingValues(0.dp),
        ) {
            Text(
                text = "ACCOUNT".toUpperCase(Locale.ROOT),
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.button,
            )
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.background
            ),
            modifier = Modifier.weight(1f),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp,
                pressedElevation = 0.dp,
                disabledElevation = 0.dp,
            ),
            contentPadding = PaddingValues(0.dp),
        ) {
            Text(
                text = "WATCHLIST".toUpperCase(Locale.ROOT),
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.button,
            )
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.background
            ),
            modifier = Modifier.weight(1f),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp,
                pressedElevation = 0.dp,
                disabledElevation = 0.dp,
            ),
            contentPadding = PaddingValues(0.dp),
        ) {
            Text(

                text = "PROFILE".toUpperCase(Locale.ROOT),
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.button,
            )
        }
    }
}
