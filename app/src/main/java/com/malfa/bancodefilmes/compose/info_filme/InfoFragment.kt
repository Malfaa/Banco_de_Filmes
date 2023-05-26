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
import com.malfa.bancodefilmes.R
import com.malfa.bancodefilmes.retrofit.models.Filme
import com.malfa.bancodefilmes.ui.theme.Shapes
import com.malfa.bancodefilmes.ui.theme.Typography
import com.malfa.bancodefilmes.ui.theme.background
import com.malfa.bancodefilmes.ui.theme.background_info

@Composable
fun InfoFragment(filme: Filme){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(background)
            .fillMaxHeight()
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        AsyncImage(
            model = filme.Poster,
            contentDescription = stringResource(id = R.string.poster_content_description).format(
                filme.Title
            ),
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
                TextoInfo(R.string.titulo_info, filme.Title)
                TextoInfo(R.string.genero_info, filme.Genre)
                TextoInfo(R.string.rated_info, filme.Rated)
                TextoInfo(R.string.lancado_info, filme.Released)
                TextoInfo(R.string.ano_info, filme.Year)
                TextoInfo(R.string.plot_info, filme.Plot)
                TextoInfo(R.string.director_info, filme.Director)
                TextoInfo(R.string.writer_info, filme.Writer)
                TextoInfo(R.string.actors_info, filme.Actors)
                TextoInfo(R.string.runtime_info, filme.Runtime)
                TextoInfo(R.string.language_info, filme.Language)
                TextoInfo(R.string.country_info, filme.Country)
                TextoInfo(R.string.awards_info, filme.Awards)
//            TextoInfo(R.string.ratings_info, filme.Ratings)
                TextoInfo(R.string.metascore_info, filme.Metascore)
                TextoInfo(R.string.imdb_rating_info, filme.imdbRating)
                TextoInfo(R.string.imdb_id_info, filme.imdbID)
                TextoInfo(R.string.type_info, filme.Type)
                TextoInfo(R.string.dvd_info, filme.DVD)
                TextoInfo(R.string.box_office_info, filme.BoxOffice)
                TextoInfo(R.string.production_info, filme.Production)
                TextoInfo(R.string.website_info, filme.Website)
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
    val dummy = Filme(
        1,
        "Ice Age",
        "2012","PG",null,null,"Adventure",null,null,null,null,null,null,null,
        "https://m.media-amazon.com/images/M/MV5BOGEwMTQyMDktMWUwZC00MzExLTg1MGMtYWJiNWNhMzIyMGU5XkEyXkFqcGdeQXVyOTYyMTY2NzQ@._V1_SX300.jpg",
        null,null,null,null,null,null,null,null,null,"true")
    InfoFragment(filme = dummy)
}