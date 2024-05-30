package com.example.composeoptimization.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

/**
 * Author: lidongjie
 * Date: 2024/5/28
 * SinceVer: 1.0.0
 * Desc: 稳定性优化
 */

@Composable
fun StabilityPage() {
    val user by remember { mutableStateOf(User("Tim", 20)) }
    var selected by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Checkbox(checked = selected, { selected = it })
        UserLayout(user)
    }
}

@Composable
private fun UserLayout(user: User) {
    Text(text = "${user.name} , ${user.age}")
}

private class User(val name: String, var age: Int)


@Composable
fun StabilityListPage() {
    val userList by remember {
        mutableStateOf(listOf(User("Tim", 20), User("Jack", 30)))
    }
    var selected by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Checkbox(checked = selected, { selected = it })
        UserListLayout(userList)
//        UserImmutableList(userList.toImmutableList())
    }
}

@Composable
private fun UserListLayout(uses: List<User>) {
    LazyColumn {
        items(items = uses, key = { item -> item.name }) {
            Text(text = "${it.name} , ${it.age}")
        }
    }
}

@Composable
private fun UserImmutableList(uses: ImmutableList<User>) {
    LazyColumn {
        items(items = uses, key = { item -> item.name }) {
            Text(text = "${it.name} , ${it.age}")
        }
    }
}