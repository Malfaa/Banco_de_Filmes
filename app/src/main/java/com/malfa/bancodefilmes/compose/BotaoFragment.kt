package com.malfa.bancodefilmes.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BotaoFragment(acao: Unit, text: String){ //fixme arrumar composable
    Row(){
        Button(
            onClick = { acao }
        ) {
            Text(text = text)
        }
    }
}

@Preview
@Composable
fun BotaoPreview(){
//    BotaoFragment()
}
