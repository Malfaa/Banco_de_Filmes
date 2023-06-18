package com.malfa.bancodefilmes.compose.cartaz

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.malfa.bancodefilmes.R
import com.malfa.bancodefilmes.retrofit.models.Filme

@Composable
fun ClassificacaoImagem(filme: Filme){
    val imagem = when (filme.Rated) {
        "G" -> R.drawable.livre_vetor
        "PG" -> R.drawable.dez_vetor
        "PG-13" -> R.drawable.catorze_vetor
        "R" -> R.drawable.dezesseis_vetor
        else -> R.drawable.dezoito_vetor
    }
    Image(
        painterResource(id = imagem),
        modifier = Modifier
            .size(45.dp)
            .padding(4.dp),
//                contentScale = ContentScale.Crop,
        contentDescription = null
    )
}