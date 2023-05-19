package com.malfa.bancodefilmes.compose.cartaz

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.malfa.bancodefilmes.MainViewModel
import com.malfa.bancodefilmes.R
import com.malfa.bancodefilmes.ui.theme.cartaz_bg

@Composable
fun SearchFragment(modifier: Modifier, viewModel: MainViewModel){
    var text by rememberSaveable {
        mutableStateOf(TextFieldValue(""))
    }

    Row(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = text,
            onValueChange = { novoTexto ->
                text = novoTexto
            },
            placeholder = {Text(stringResource(id = R.string.search))},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = stringResource(id = R.string.movie_icon)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = MaterialTheme.colors.surface),
            modifier = Modifier
                .heightIn(min = 56.dp)
                .padding(20.dp)
                .fillMaxWidth(0.75F),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        )
        Spacer(modifier = modifier.width(10.dp))
        Button(
            onClick = {
                try {
                    viewModel.atualizandoFilme(text.text
                        .lowercase()
                        .replace("/[^A-Z0-9]+/ig", "_")
                    )
                }catch (e : Exception){
                    Log.e("SearchFragment", e.message.toString())
//                Toast.makeText(LocalContext.current.applicationContext, "Filme não encontrado.\nTente novamente.", Toast.LENGTH_SHORT).show()
                }
                text.text.isEmpty()
            } ,
            colors = ButtonDefaults.buttonColors(cartaz_bg),
            modifier = Modifier
                .align(alignment = Alignment.CenterVertically)
        ){
            Image(
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(id = R.string.search_movie)
            )
        }

    }
}

@Preview
@Composable
fun SearchPreview(){
//    SearchFragment(modifier = Modifier, viewModel = MainViewModel(RepositorioImpl(OmdbApi, FilmeDatabase.getInstance())))
    var valor by remember {
        mutableStateOf("")
    }
    Row(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = valor,
            onValueChange = {valor = it},
            placeholder = {Text(stringResource(id = R.string.search))},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = stringResource(id = R.string.movie_icon)
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
            onClick = {valor.isEmpty()},
            colors = ButtonDefaults.buttonColors(cartaz_bg),
            modifier = Modifier
                .align(alignment = Alignment.CenterVertically)
        ) {
            Image(
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(id = R.string.search_movie)
            )
        }
    }
}