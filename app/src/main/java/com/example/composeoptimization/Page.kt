package com.example.composeoptimization

/**
 * Author: lidongjie
 * Date: 2024/5/28
 * SinceVer: TODO: 哪个版本添加的
 * Desc: TODO: 需求文档url（可选），简单说明
 */
sealed interface Page {
    val name: String

    object Home : Page {
        override val name: String = "Home"
    }

    object First : Page {
        override val name: String = "First"
    }

    object Second : Page {
        override val name: String = "Second"
    }

    object Third : Page {
        override val name: String = "Third"
    }
}

val PAGE_LIST get() = listOf<Page>(Page.First, Page.Second, Page.Third)