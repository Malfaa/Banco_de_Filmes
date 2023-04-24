package com.malfa.bancodefilmes.compose.cartaz

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import com.malfa.bancodefilmes.MainViewModel

@Composable
fun SearchFragment(modifier: Modifier, viewModel: MainViewModel){
    Row() {
        var text by remember {
            mutableStateOf(TextFieldValue(""))
        }

        TextField(value = text, onValueChange = { novoTexto ->
            text = novoTexto
        })

       try {
            viewModel.atualizandoFilme(text.text
                .lowercase()
                .replace("/[^A-Z0-9]+/ig", "_")
            )
        }catch (e : Exception){
            Log.e("SearchFragment", e.message.toString())
        }
    }
}