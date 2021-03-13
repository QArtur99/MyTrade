package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import java.util.*

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