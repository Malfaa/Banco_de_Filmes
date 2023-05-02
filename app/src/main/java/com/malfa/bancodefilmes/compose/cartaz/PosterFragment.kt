package com.malfa.bancodefilmes.compose.cartaz

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.malfa.bancodefilmes.MainViewModel
import com.malfa.bancodefilmes.R
import com.malfa.bancodefilmes.compose.MainFragment
import com.malfa.bancodefilmes.compose.info_filme.InfoFragment
import com.malfa.bancodefilmes.ui.theme.cartaz_bg

@Composable
fun PosterFragment(modifier: Modifier, viewModel: MainViewModel){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") { MainFragment() }
        composable("info"){ InfoFragment(viewModel) }
    }
    Column(
        modifier = modifier
            .background(cartaz_bg)
            .clickable {
                navController.navigate("info") {
                    popUpTo("main")
                }
            }

    ) {
        AsyncImage(model = viewModel.filmes.Poster, contentDescription = null)

        Row() {
            Text(text = viewModel.filmes.Title.toString())
            Spacer(modifier = modifier.width(20.dp))
            val imagem = when (viewModel.filmes.Rated) {
                "G" -> R.drawable.livre_vetor
                "PG" -> R.drawable.dez_vetor
                "PG-13" -> R.drawable.catorze_vetor
                "R" -> R.drawable.dezesseis_vetor
                else  -> R.drawable.dezoito_vetor
            }
            AsyncImage(model = imagem, contentDescription = null)

        }

        Text(text = viewModel.filmes.Genre.toString())

    }

}