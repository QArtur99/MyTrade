package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.data.ScreenState
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.ui.theme.transparent
import java.util.*

@Composable
fun Welcome(isDarkTheme: Boolean, navController: NavController) {
    val backgroundRes = R.drawable.ic_welcome_bg
    val logo = R.drawable.ic_logo

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = MaterialTheme.colors.background),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            imageVector = ImageVector.vectorResource(id = backgroundRes),
            contentDescription = "welcome background",
            contentScale = ContentScale.FillBounds,
        )
        Icon(
            imageVector = ImageVector.vectorResource(id = logo),
            contentDescription = "logo",
            tint = MaterialTheme.colors.onBackground
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier
                    .height(48.dp)
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    shape = shapes.medium,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.primary
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 0.dp,
                        pressedElevation = 0.dp,
                        disabledElevation = 0.dp,
                    ),
                ) {
                    Text(
                        text = "get started".toUpperCase(Locale.ROOT),
                        color = MaterialTheme.colors.onPrimary,
                        style = MaterialTheme.typography.button,
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                OutlinedButton(
                    onClick = {
                        navController.navigate(route = ScreenState.Login)
                    },
                    shape = shapes.medium,
                    border = BorderStroke(1.dp, MaterialTheme.colors.primary),
                    modifier = Modifier
                        .weight(1f)
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
                    Text(
                        text = "log in".toUpperCase(Locale.ROOT),
                        color = MaterialTheme.colors.primary,
                        style = MaterialTheme.typography.button,
                    )
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Spacer(modifier = Modifier.height(48.dp))
        }
    }
}