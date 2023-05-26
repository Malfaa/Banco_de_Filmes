package com.malfa.bancodefilmes.compose.cartaz

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.malfa.bancodefilmes.IMainViewModel
import com.malfa.bancodefilmes.MainViewModelPreview
import com.malfa.bancodefilmes.R
import com.malfa.bancodefilmes.ui.theme.cartaz_bg

@Composable
fun SearchFragment(modifier: Modifier, viewModel: IMainViewModel){ // TODO: preview
    var text by rememberSaveable {
        mutableStateOf("")
    }

    SearchContent(text, eventoText = {text = it},modifier, viewModel)
}

@Composable
private fun SearchContent(
    text: String,
    eventoText: (String) -> Unit,
    modifier: Modifier,
    viewModel: IMainViewModel
) {
    Row(modifier = Modifier
        .padding(end = 15.dp)
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = eventoText,
            placeholder = { Text(stringResource(id = R.string.search)) },
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
                    viewModel.atualizandoFilme(
                        text
                            .lowercase()
                            .replace("/[^A-Z0-9]+/ig", "_")
                    )
                } catch (e: Exception) {
                    Log.e("SearchFragment", e.message.toString())
//                Toast.makeText(LocalContext.current.applicationContext, "Filme não encontrado.\nTente novamente.", Toast.LENGTH_SHORT).show()
                }finally {
                    Log.d("Clicado","Botão clicado")
                }
                text.isEmpty()
            },
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

@Preview
@Composable
fun SearchPreview(){
    SearchFragment(modifier = Modifier, viewModel = MainViewModelPreview())
}