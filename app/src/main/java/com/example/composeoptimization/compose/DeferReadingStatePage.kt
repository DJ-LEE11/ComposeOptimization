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
 * Desc: 推迟阅读状态
 */

@Composable
fun DeferReadingStatePage() {
    var random by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.clickable { random = (1..99).shuffled().first() },
            text = "点击我生成随机数"
        )
        Content(random)
    }
}

@Composable
private fun Content(random: Int) {
    Text(text = random.toString())
}


@Composable
private fun Content(random: () -> Int) {
    Text(text = random().toString())
}