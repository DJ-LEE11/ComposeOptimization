package com.example.composeoptimization.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameMillis
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.example.composeoptimization.R

/**
 * Author: lidongjie
 * Date: 2024/5/28
 * SinceVer: 1.0.0
 * Desc: 推迟阅读状态&Lambda优化
 */

@Composable
fun DeferReadingStatePage() {
    val logo = painterResource(id = R.drawable.compose_logo)
    var size by remember { mutableStateOf(IntSize.Zero) }
    val logoPosition by logoPosition(size = size, logoSize = logo.intrinsicSize)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .onPlaced {
                size = it.size
            }
    ) {
        with(LocalDensity.current) {
            ImageItem1(logo, logoPosition)
//            ImageItem2(logo, { logoPosition })
//            Image(
//                painter = logo,
//                contentDescription = "logo",
//                modifier = Modifier.offset { logoPosition }
//            )
        }
    }
}

@Composable
fun ImageItem(logo: Painter, offset: () -> IntOffset) {
    Image(
        painter = logo,
        contentDescription = "logo",
        modifier = Modifier.offset { offset() }
    )
}

@Composable
fun ImageItem1(logo: Painter, offset: IntOffset) {
    Image(
        painter = logo,
        contentDescription = "logo",
        modifier = Modifier.offset { { offset }() }
    )
}

@Composable
fun ImageItem2(logo: Painter, offset: () -> IntOffset) {
    Image(
        painter = logo,
        contentDescription = "logo",
        modifier = Modifier.offset(x = offset().x.dp, y = offset().y.dp)
    )
}

@Composable
fun logoPosition(size: IntSize, logoSize: Size): State<IntOffset> =
    produceState(initialValue = IntOffset.Zero, size, logoSize) {
        if (size == IntSize.Zero) {
            this.value = IntOffset.Zero
            return@produceState
        }

        var xDirection = 1
        var yDirection = 1

        while (true) {
            withFrameMillis {
                value += IntOffset(x = MOVE_SPEED * xDirection, y = MOVE_SPEED * yDirection)

                if (value.x <= 0 || value.x >= size.width - logoSize.width) {
                    xDirection *= -1
                }

                if (value.y <= 0 || value.y >= size.height - logoSize.height) {
                    yDirection *= -1
                }
            }
        }
    }

internal const val MOVE_SPEED = 10