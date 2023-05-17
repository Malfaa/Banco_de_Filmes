package com.malfa.bancodefilmes.compose.info_filme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.malfa.bancodefilmes.MainViewModel
import com.malfa.bancodefilmes.R
import com.malfa.bancodefilmes.ui.theme.Shapes
import com.malfa.bancodefilmes.ui.theme.Typography
import com.malfa.bancodefilmes.ui.theme.background
import com.malfa.bancodefilmes.ui.theme.background_info

@Composable
fun InfoFragment( viewModel : MainViewModel){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(background)
            .fillMaxHeight()
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        AsyncImage(
            model = viewModel.filmes.value?.Poster,
            contentDescription = stringResource(id = R.string.poster_content_description).format(viewModel.filmes.value?.Title),
            modifier = Modifier
                .height(420.dp)
                .width(420.dp)
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        Surface(
            shape = Shapes.small,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(background_info)
                    .padding(start = 8.dp, top = 8.dp)
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth(0.75F)
                    .fillMaxHeight(0.75F),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                TextoInfo(R.string.titulo_info, viewModel.filmes.value?.Title)
                TextoInfo(R.string.genero_info, viewModel.filmes.value?.Genre)
                TextoInfo(R.string.rated_info, viewModel.filmes.value?.Rated)
                TextoInfo(R.string.lancado_info, viewModel.filmes.value?.Released)
                TextoInfo(R.string.ano_info, viewModel.filmes.value?.Year)
                TextoInfo(R.string.plot_info, viewModel.filmes.value?.Plot)
                TextoInfo(R.string.director_info, viewModel.filmes.value?.Director)
                TextoInfo(R.string.writer_info, viewModel.filmes.value?.Writer)
                TextoInfo(R.string.actors_info, viewModel.filmes.value?.Actors)
                TextoInfo(R.string.runtime_info, viewModel.filmes.value?.Runtime)
                TextoInfo(R.string.language_info, viewModel.filmes.value?.Language)
                TextoInfo(R.string.country_info, viewModel.filmes.value?.Country)
                TextoInfo(R.string.awards_info, viewModel.filmes.value?.Awards)
//            TextoInfo(R.string.ratings_info, viewModel.filmes.value?.Ratings)
                TextoInfo(R.string.metascore_info, viewModel.filmes.value?.Metascore)
                TextoInfo(R.string.imdb_rating_info, viewModel.filmes.value?.imdbRating)
                TextoInfo(R.string.imdb_id_info, viewModel.filmes.value?.imdbID)
                TextoInfo(R.string.type_info, viewModel.filmes.value?.Type)
                TextoInfo(R.string.dvd_info, viewModel.filmes.value?.DVD)
                TextoInfo(R.string.box_office_info, viewModel.filmes.value?.BoxOffice)
                TextoInfo(R.string.production_info, viewModel.filmes.value?.Production)
                TextoInfo(R.string.website_info, viewModel.filmes.value?.Website)
            }
        }
    }
}

@Composable
fun TextoInfo(id: Int, text: String?){
    Text(
        text = stringResource(id = id)
            .format(text),
        style = Typography.h6,
        color = Color.White)
}
@Preview
@Composable
fun InfoPreview(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(background)
            .fillMaxHeight()
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        AsyncImage(
            model = "https://m.media-amazon.com/images/M/MV5BOGEwMTQyMDktMWUwZC00MzExLTg1MGMtYWJiNWNhMzIyMGU5XkEyXkFqcGdeQXVyOTYyMTY2NzQ@._V1_SX300.jpg",
            modifier = Modifier
                .padding(16.dp)
                .height(420.dp)
                .width(420.dp),
            contentDescription = stringResource(id = R.string.poster_content_description).format("Teste")
        )
        Spacer(modifier = Modifier.height(15.dp))

        Surface(shape = Shapes.small, modifier = Modifier.padding(bottom = 16.dp)) {
            Column(
                modifier = Modifier
                    .background(background_info)
                    .padding(start = 8.dp, top = 8.dp, bottom = 8.dp)
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth(0.75F)
                    .fillMaxHeight(0.75F)
                    ,
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween,

            ) {
                TextoInfo(R.string.titulo_info, "Ice Age")
                TextoInfo(R.string.genero_info, "Teste")
                Text(text = stringResource(id = R.string.rated_info).format("Teste"), style = Typography.h6, color = Color.White)
                Text(text = stringResource(id = R.string.lancado_info).format("Teste"), style = Typography.h6, color = Color.White)
                Text(text = stringResource(id = R.string.ano_info).format("Teste"), style = Typography.h6, color = Color.White)
                Text(text = stringResource(id = R.string.plot_info).format("Teste"), style = Typography.h6, color = Color.White)
                Text(text = stringResource(id = R.string.director_info).format("Teste"), style = Typography.h6, color = Color.White)
                Text(text = stringResource(id = R.string.writer_info).format("Teste"), style = Typography.h6, color = Color.White)
                Text(text = stringResource(id = R.string.actors_info).format("Teste"), style = Typography.h6, color = Color.White)
                Text(text = stringResource(id = R.string.runtime_info).format("Teste"), style = Typography.h6, color = Color.White)
                Text(text = stringResource(id = R.string.language_info).format("Teste"), style = Typography.h6, color = Color.White)
                Text(text = stringResource(id = R.string.country_info).format("Teste"), style = Typography.h6, color = Color.White)
                Text(text = stringResource(id = R.string.awards_info).format("Teste"), style = Typography.h6, color = Color.White)
//            Text(text = stringResource(id = R.string.ratings_info).format("Teste").Ratings, style = Typography.h6, color = Color.White)
                Text(text = stringResource(id = R.string.metascore_info).format("Teste"), style = Typography.h6, color = Color.White)
                Text(text = stringResource(id = R.string.imdb_rating_info).format("Teste"), style = Typography.h6, color = Color.White)
                Text(text = stringResource(id = R.string.imdb_id_info).format("Teste"), style = Typography.h6, color = Color.White)
                Text(text = stringResource(id = R.string.type_info).format("Teste"), style = Typography.h6, color = Color.White)
                Text(text = stringResource(id = R.string.dvd_info).format("Teste"), style = Typography.h6, color = Color.White)
                Text(text = stringResource(id = R.string.box_office_info).format("Teste"), style = Typography.h6, color = Color.White)
                Text(text = stringResource(id = R.string.production_info).format("Teste"), style = Typography.h6, color = Color.White)
                Text(text = stringResource(id = R.string.website_info).format("Teste"), style = Typography.h6, color = Color.White)
            }
        }
    }
}