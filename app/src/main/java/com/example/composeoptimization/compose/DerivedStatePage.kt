package com.example.composeoptimization.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * Author: lidongjie
 * Date: 2024/5/28
 * SinceVer: 1.0.0
 * Desc: 衍生状态优化
 */

@Composable
fun DerivedStatePage() {
    var clickCount by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(modifier = Modifier.clickable { clickCount++ }, text = "Click me")
        if (clickCount >= 5) {
            Text(text = "You clicked a lot")
        }
    }
}