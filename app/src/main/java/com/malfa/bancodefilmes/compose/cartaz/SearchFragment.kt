package com.malfa.bancodefilmes.compose.cartaz

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import com.malfa.bancodefilmes.MainViewModel

@Composable
fun SearchFragment(modifier: Modifier, viewModel: MainViewModel){
    Row() {
        var text by remember {
            mutableStateOf(TextFieldValue(""))
        }

        OutlinedTextField(
            value = text,
            onValueChange = { novoTexto ->
                text = novoTexto
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = "ícone de filme"
                )
            }
        )
        try {
            viewModel.atualizandoFilme(text.text
                .lowercase()
                .replace("/[^A-Z0-9]+/ig", "_")
            )
        }catch (e : Exception){
            Log.e("SearchFragment", e.message.toString())
            Toast.makeText(LocalContext.current, "Filme não encontrado.\nTente novamente.", Toast.LENGTH_SHORT).show()
        }
    }
}