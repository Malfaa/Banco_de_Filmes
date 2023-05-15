package com.malfa.bancodefilmes.compose.cartaz

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
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
        SubcomposeAsyncImage(model = viewModel.filmes.value?.Poster, contentDescription = null)

        Row() {
            Text(text = viewModel.filmes.value?.Title.toString())
            Spacer(modifier = modifier.width(20.dp))
            val imagem = when (viewModel.filmes.value?.Rated) {
                "G" -> R.drawable.livre_vetor
                "PG" -> R.drawable.dez_vetor
                "PG-13" -> R.drawable.catorze_vetor
                "R" -> R.drawable.dezesseis_vetor
                else  -> R.drawable.dezoito_vetor
            }
            SubcomposeAsyncImage(model = imagem, contentDescription = null)

        }

        Text(text = viewModel.filmes.value?.Genre.toString())

    }

}

@Preview
@Composable
fun Teste(modifier: Modifier = Modifier){ //todo entender como que funciona o layout no compose
    // depois corrigir o problema de memory leak

    Column(
        modifier = modifier
//            .padding(start = 80.dp, end = 80.dp, bottom = 80.dp, top = 40.dp)
            .background(cartaz_bg)
    ) {
        AsyncImage(
            model = "https://m.media-amazon.com/images/M/MV5BOGEwMTQyMDktMWUwZC00MzExLTg1MGMtYWJiNWNhMzIyMGU5XkEyXkFqcGdeQXVyOTYyMTY2NzQ@._V1_SX300.jpg",
            contentDescription = null,
            alignment = Alignment.Center,
            modifier = modifier
                .height(300.dp)
                .width(300.dp)
        )



        Text(text = "Aventura")
    }
    Row(modifier = modifier) {
        Text(text = "Ice Age")
        Spacer(modifier = modifier.width(20.dp))
        Image(painterResource(id = R.drawable.livre_vetor), contentDescription = null)

    }
}