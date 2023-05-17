package com.malfa.bancodefilmes.compose.cartaz

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.malfa.bancodefilmes.MainViewModel
import com.malfa.bancodefilmes.R
import com.malfa.bancodefilmes.ui.theme.Typography
import com.malfa.bancodefilmes.ui.theme.cartaz_bg

@Composable
fun PosterFragment(modifier: Modifier, viewModel: MainViewModel){
//    val navController = rememberNavController() fixme problema é aqui
//
//    NavHost(navController = navController, startDestination = "main") {
//        composable("main") { MainFragment() }
//        composable("info") { InfoFragment(viewModel) } fixme onValueChange muda tela
//    }
    Surface(modifier = modifier.padding(40.dp)) {
        Column(modifier = modifier
            .background(cartaz_bg)
//            .clickable {
//                navController.navigate("info") {
//                    popUpTo("main")
//                }
//            }
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp, bottom = 40.dp)
            ) {
                AsyncImage(
                    model = viewModel.filmes.value?.Poster,
                    contentDescription = null,
                    modifier = modifier
                        .height(300.dp)
                        .width(300.dp)
                )
            }

            Row(modifier = modifier.fillMaxWidth()) {
                Text(
                    text = viewModel.filmes.value?.Title.toString(),
                    style = Typography.h4,
                    modifier = modifier
                        .padding(start = 10.dp)
                )
                Spacer(modifier = modifier.width(20.dp))
                val imagem = when (viewModel.filmes.value?.Rated) {
                    "G" -> R.drawable.livre_vetor
                    "PG" -> R.drawable.dez_vetor
                    "PG-13" -> R.drawable.catorze_vetor
                    "R" -> R.drawable.dezesseis_vetor
                    else -> R.drawable.dezoito_vetor
                }
                Image(
                    painterResource(id = imagem),
                    modifier = modifier
                        .size(45.dp)
                        .padding(4.dp),
//                contentScale = ContentScale.Crop,
                    contentDescription = null
                )
            }

            Text(
                text = viewModel.filmes.value?.Genre.toString(),
                style = Typography.h4,
                modifier = modifier
                    .paddingFromBaseline(top = 40.dp, bottom = 20.dp)
                    .padding(start = 10.dp)
            )

        }
    }
}

@Preview
@Composable
fun Teste(modifier: Modifier = Modifier) { //todo entender como que funciona o layout no compose
    // depois corrigir o problema de memory leak

    Surface(modifier = modifier.padding(40.dp)){
        Column(
            modifier = modifier
                .background(cartaz_bg)
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp, bottom = 40.dp)
            ) {
                AsyncImage(
                    model = "https://m.media-amazon.com/images/M/MV5BOGEwMTQyMDktMWUwZC00MzExLTg1MGMtYWJiNWNhMzIyMGU5XkEyXkFqcGdeQXVyOTYyMTY2NzQ@._V1_SX300.jpg",
                    contentDescription = null,
//                alignment = Alignment.Center,
                    modifier = modifier
                        .height(300.dp)
                        .width(300.dp)
                )
            }

            Row(modifier = modifier.fillMaxWidth()) {
                Text(
                    text = "Ice Age",
                    style = Typography.h4,
                    modifier = modifier
                        .padding(start = 10.dp)
                )
                Spacer(modifier = modifier.width(20.dp))
                Image(
                    painterResource(id = R.drawable.livre_vetor),
                    modifier = modifier
                        .size(45.dp)
                        .padding(4.dp),
//                contentScale = ContentScale.Crop,
                    contentDescription = null
                )
            }

            Text(
                text = "Aventura",
                style = Typography.h4,
                modifier = modifier
                    .paddingFromBaseline(top = 40.dp, bottom = 20.dp)
                    .padding(start = 10.dp)
            )

        }
    }
}