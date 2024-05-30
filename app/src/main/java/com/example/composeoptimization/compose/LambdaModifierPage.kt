package com.example.composeoptimization.compose

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.composeoptimization.R

/**
 * Author: lidongjie
 * Date: 2024/5/30
 * SinceVer: 1.0.0
 * Desc: 修饰符优化
 */
@Composable
fun LambdaModifierPage() {
    val offset by offsetAnimate()
    Box(modifier = Modifier.fillMaxSize()) {
        NiceGridUI()
        ImageAnim({ offset })
    }
}

@Composable
private fun ImageAnim(offset: () -> IntOffset) {
    Image(
        painter = painterResource(id = R.drawable.compose_logo), contentDescription = "logo",
        modifier = Modifier
            .size(80.dp)
            .offset(x = offset().x.dp, y = offset().y.dp)
    )
}

@Composable
private fun offsetAnimate(): State<IntOffset> = rememberInfiniteTransition().animateValue(
    initialValue = IntOffset(0, 0), targetValue = IntOffset(200, 400), typeConverter = IntOffset.VectorConverter,
    animationSpec = infiniteRepeatable(
        repeatMode = RepeatMode.Reverse,
        animation = tween<IntOffset>(
            durationMillis = 2000,
            easing = FastOutLinearInEasing,
        ),
    ), label = ""
)

@Composable
private fun NiceGridUI() {
    Box(modifier = Modifier.fillMaxSize())
}

/**
 * lambda修饰符优化
 */
@Composable
private fun ImageAnimLambda(offset: () -> IntOffset) {
    Image(painter = painterResource(id = R.drawable.compose_logo), contentDescription = "logo",
        modifier = Modifier
            .size(80.dp)
            .offset { offset() })
}