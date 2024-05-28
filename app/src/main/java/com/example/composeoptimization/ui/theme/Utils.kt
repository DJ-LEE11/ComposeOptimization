package com.example.composeoptimization.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

/**
 * Author: lidongjie
 * Date: 2024/5/28
 * SinceVer: 1.0.0
 * Desc: 工具
 */

@SuppressLint("ModifierFactoryUnreferencedReceiver")
@Composable
internal fun Modifier.noClickShadowModifier(onClick: () -> Unit) =
    clickable(indication = null, interactionSource = remember {
        MutableInteractionSource()
    }) {
        onClick()
    }