package com.malfa.bancodefilmes.compose.cartaz

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.malfa.bancodefilmes.R
import com.malfa.bancodefilmes.retrofit.models.Filme
import com.malfa.bancodefilmes.ui.theme.Typography
import com.malfa.bancodefilmes.ui.theme.cartaz_bg
import com.malfa.bancodefilmes.utils.Tela

@Composable
fun PosterFragment(
    navController: NavController,
    modifier: Modifier,
    filme: Filme
){
    Surface(
        modifier = modifier
            .padding(40.dp)
            .clickable(
                onClick = {
                    navController.navigate(Tela.Info.rota)
                }
            )
    ) {
        Column(modifier = modifier
            .background(cartaz_bg)
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp, bottom = 40.dp)
            ) {
                AsyncImage(
                    model = filme.Poster,
                    contentDescription = null,
                    modifier = modifier
                        .height(300.dp)
                        .width(300.dp)
                )
            }

            Row(modifier = modifier.fillMaxWidth()) {
                Text(
                    text = filme.Title.toString(),
                    style = Typography.h4,
                    modifier = modifier
                        .padding(start = 10.dp)
                )
                Spacer(modifier = modifier.width(20.dp))
                val imagem = when (filme.Rated) {
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
                text = filme.Genre.toString(),
                style = Typography.h6,
                modifier = modifier
                    .paddingFromBaseline(top = 40.dp, bottom = 20.dp)
                    .padding(start = 10.dp)
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PosterPreview(){
    val navController = rememberNavController()
    val dummy = Filme(
        1,
        "Ice Age",
        "2012","PG",null,null,"Adventure",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,"true")
    PosterFragment(navController = navController, modifier = Modifier, filme = dummy)
}