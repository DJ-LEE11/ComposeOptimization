package com.example.composeoptimization.compose

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeoptimization.ui.theme.noClickShadowModifier

/**
 * Author: lidongjie
 * Date: 2024/5/28
 * SinceVer: 1.0.0
 * Desc: TestPage
 */

@Composable
fun TestPage() {
    var random by remember { mutableStateOf(0) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            modifier = Modifier.noClickShadowModifier {
                random = (1..99).shuffled().first()
            },
            text = "点击我生成随机数",
        )
        Content(random)
    }
}

@Composable
private fun Content(random: Int) {
    Text(
        text = random.toString(),
    )
}