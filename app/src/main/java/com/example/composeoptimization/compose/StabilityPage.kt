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
    val contact1 by remember { mutableStateOf(Contact("112", "222")) }
    var selected by remember { mutableStateOf(false) }

    var contactList1 by remember {
        mutableStateOf(
            listOf(Contact("aaa", "222"), Contact("bbb", "222"))
        )
    }
    Column {
        Checkbox(checked = selected, {
//            contactList1 = listOf(
//                Contact("aaa", "222"), Contact("bbb", "222"), Contact("ccc", "333")
//            )
            selected = it
        })
        Text(text = "点击我", Modifier.noClickShadowModifier {
            contactList1 = listOf(
                Contact("aaa", "222"), Contact("bbb", "222"), Contact("ccc", "333"), Contact(
                    "ddd",
                    "333"
                )
            )
        })
//        ContactInfo({ contact1 })
//        ContactInfoList({ contactList1 })
        ContactInfoList1(contactList1.toImmutableList())
    }
}

@Composable
fun ContactInfo(info: () -> Contact) {
    Text(text = "${info().name} ${info().phone}")
}

@Composable
fun ContactInfoList(infos: () -> List<Contact>) {
    LazyColumn {
        this.items(items = infos(), key = { item -> item.name }) {
            Text(text = "${it.name} ${it.phone}")
        }
    }
}

@Composable
fun ContactInfoList1(infos: ImmutableList<Contact>) {
    LazyColumn {
        this.items(items = infos, key = { item -> item.name }) {
            Text(text = "${it.name} ${it.phone}")
        }
    }
}

class Contact(val name: String, val phone: String)