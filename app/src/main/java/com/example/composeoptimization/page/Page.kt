package com.example.composeoptimization.page

import androidx.compose.runtime.Composable
import com.example.composeoptimization.App
import com.example.composeoptimization.compose.DeferReadingStatePage
import com.example.composeoptimization.compose.DerivedStatePage
import com.example.composeoptimization.compose.LambdaModifierPage
import com.example.composeoptimization.compose.ListPage
import com.example.composeoptimization.compose.StabilityPage
import com.example.composeoptimization.compose.TestPage

/**
 * Author: lidongjie
 * Date: 2024/5/28
 * SinceVer: 1.0.0
 * Desc: 页面
 */
sealed interface Page {
    val name: String

    @Composable
    fun page()

    object Home : Page {
        override val name: String = "HomePage"

        @Composable
        override fun page() = App()
    }

    object DeferReadingState : Page {
        override val name: String = "Defer Reading State"

        @Composable
        override fun page() = DeferReadingStatePage()
    }

    object LamdbaModifer : Page {
        override val name: String = "Lambda Modifier"

        @Composable
        override fun page() = LambdaModifierPage()
    }

    object Stability : Page {
        override val name: String = "Stability"

        @Composable
        override fun page() = StabilityPage()
    }

    object DerivedState : Page {
        override val name: String = "Derived State"

        @Composable
        override fun page() = DerivedStatePage()
    }

    object List : Page {
        override val name: String = "List"

        @Composable
        override fun page() = ListPage()
    }

    object Test : Page {
        override val name: String = "Test"

        @Composable
        override fun page() = TestPage()
    }
}

val PageList = listOf(
    Page.DeferReadingState,
    Page.LamdbaModifer,
    Page.Stability,
    Page.DerivedState,
    Page.List,
    Page.Test,
)