package com.malfa.bancodefilmes.compose.cartaz

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import coil.compose.AsyncImage
import com.malfa.bancodefilmes.MainViewModel
import com.malfa.bancodefilmes.R

@Composable
fun PosterFragment(modifier: Modifier, viewModel: MainViewModel){
    Column(
        modifier = modifier
            .clickable {  }
//            .background(Color)

    ) {
        AsyncImage(model = viewModel.filmes.Poster, contentDescription = null)

        Row() {
            Text(text = viewModel.filmes.Title)
            val imagem = when (viewModel.filmes.Rated) {
                "G" -> R.drawable.livre_vetor
                "PG" -> R.drawable.dez_vetor
                "PG-13" -> R.drawable.catorze_vetor
                "R" -> R.drawable.dezesseis_vetor
                else  -> R.drawable.dezoito_vetor
            }
            AsyncImage(model = imagem, contentDescription = null)

        }

        Text(text = viewModel.filmes.Genre)

    }

}