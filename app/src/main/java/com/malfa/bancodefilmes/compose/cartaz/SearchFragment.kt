package com.malfa.bancodefilmes.compose.cartaz

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            },

        )
        Spacer(modifier = modifier.width(10.dp))
        Button(onClick = {
            try {
                viewModel.atualizandoFilme(text.text
                    .lowercase()
                    .replace("/[^A-Z0-9]+/ig", "_")
                )
            }catch (e : Exception){
                Log.e("SearchFragment", e.message.toString())
//                Toast.makeText(LocalContext.current.applicationContext, "Filme não encontrado.\nTente novamente.", Toast.LENGTH_SHORT).show()
            }}){
            Image(imageVector = Icons.Default.Search, contentDescription = "Pesquisar Filme")
        } 

    }
}

@Preview
@Composable
fun SearchPreview(){
//    SearchFragment()
}