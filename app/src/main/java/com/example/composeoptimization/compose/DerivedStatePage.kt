package com.example.composeoptimization.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.composeoptimization.ui.theme.noClickShadowModifier

/**
 * Author: lidongjie
 * Date: 2024/5/28
 * SinceVer: 1.0.0
 * Desc: 衍生状态优化
 */

@Composable
fun DerivedStatePage() {
    var clickCount by remember { mutableStateOf(0) }
    val clickedALot by remember { derivedStateOf { clickCount >= 3 } }
    Column {
        Box(modifier = Modifier.clickable { clickCount++ }) {
            Text(text = "Click me")
        }
        if (clickedALot) {
            Text(text = "You clicked a lot")
        }
    }
}