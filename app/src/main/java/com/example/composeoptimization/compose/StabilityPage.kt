package com.example.composeoptimization.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.composeoptimization.ui.theme.noClickShadowModifier
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
    val contact by remember { mutableStateOf(Contact("qqqq", "111")) }
    var selected by remember { mutableStateOf(false) }

    var contactList by remember {
        mutableStateOf(listOf(Contact("aaa", "111"), Contact("bbb", "222")))
    }
    Column {
        Checkbox(checked = selected, {
            selected = it
        })
//        ContactLayout(contact)
        Text(text = "点击我", Modifier.noClickShadowModifier {
            contactList = listOf(Contact("aaa", "111"), Contact("bbb", "222"), Contact("ccc", "333"))
        })
//        ContactList(contactList)
//        ContactListLambdaLayout({ contactList })
        ContactImmutableList(contactList.toImmutableList())
    }
}

class Contact(val name: String, val phone: String)

@Composable
fun ContactLayout(info: Contact) {
    Text(text = "${info.name} , ${info.phone}")
}

@Composable
fun ContactList(infos: List<Contact>) {
    LazyColumn {
        this.items(items = infos, key = { item -> item.name }) {
            Text(text = "${it.name} ${it.phone}")
        }
    }
}

@Composable
fun ContactImmutableList(infos: ImmutableList<Contact>) {
    LazyColumn {
        this.items(items = infos, key = { item -> item.name }) {
            Text(text = "${it.name} ${it.phone}")
        }
    }
}

@Composable
fun ContactListLambdaLayout(infos: () -> List<Contact>) {
    LazyColumn {
        this.items(items = infos(), key = { item -> item.name }) {
            Text(text = "${it.name} , ${it.phone}")
        }
    }
}