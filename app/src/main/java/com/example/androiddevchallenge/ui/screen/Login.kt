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

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.data.ScreenState
import com.example.androiddevchallenge.ui.theme.shapes
import java.util.Locale

@Composable
fun Login(isDarkTheme: Boolean, navController: NavController) {

    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    val backgroundRes = R.drawable.ic_login_bg

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = MaterialTheme.colors.surface),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                imageVector = ImageVector.vectorResource(id = backgroundRes),
                contentDescription = "welcome background",
                contentScale = ContentScale.FillBounds,
            )
            Spacer(modifier = Modifier.height(40.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .height(56.dp),
                value = emailState.value,
                onValueChange = { emailState.value = it },
                label = {
                    Row {
                        Icon(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_mail_outline_24),
                            contentDescription = "logo",
                            tint = MaterialTheme.colors.onSurface
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            text = "Email address",
                            color = MaterialTheme.colors.onSurface,
                            style = MaterialTheme.typography.body1,
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = MaterialTheme.colors.onSurface,
                    backgroundColor = MaterialTheme.colors.surface
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .height(56.dp),
                value = emailState.value,
                onValueChange = { passwordState.value = it },
                label = {
                    Row {
                        Icon(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_password_24),
                            contentDescription = "logo",
                            tint = MaterialTheme.colors.onSurface
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            text = "Password",
                            color = MaterialTheme.colors.onSurface,
                            style = MaterialTheme.typography.body1,
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = MaterialTheme.colors.onSurface,
                    backgroundColor = MaterialTheme.colors.surface
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    navController.navigate(route = ScreenState.Home)
                },
                shape = shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary
                ),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp,
                    disabledElevation = 0.dp,
                ),
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(
                    text = "Log in".toUpperCase(Locale.ROOT),
                    color = MaterialTheme.colors.onPrimary,
                    style = MaterialTheme.typography.button,
                )
            }
        }

        Column {
            Box(
                modifier = Modifier.height(152.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Welcome",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onBackground,
                    style = MaterialTheme.typography.h2,
                )
            }
            Box {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "back",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onBackground,
                    style = MaterialTheme.typography.h2,
                )
            }
        }
    }
}
