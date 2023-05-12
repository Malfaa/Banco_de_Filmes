package com.malfa.bancodefilmes.compose.cartaz

import android.graphics.Color
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import com.malfa.bancodefilmes.MainViewModel
import com.malfa.bancodefilmes.ui.theme.*

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
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = "ícone de filme"
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = MaterialTheme.colors.surface),
            modifier = Modifier
                .heightIn(min = 56.dp)
                .padding(20.dp)
                .fillMaxWidth(0.75F),
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
    Row(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = "ícone de filme"
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = MaterialTheme.colors.surface),
            modifier = Modifier
                .heightIn(min = 56.dp)
                .padding(20.dp)
                .fillMaxWidth(0.75F),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Spacer(modifier = Modifier.width(10.dp))


        Button(
            onClick = {},
            modifier = Modifier
                .background(cartaz_bg, shape = Shapes.medium)
                .align(alignment = Alignment.CenterVertically)
        ) {
            Image(
                imageVector = Icons.Default.Search,
                contentDescription = "Pesquisar Filme"
            )
        }
    }
}