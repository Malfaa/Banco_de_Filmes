package com.malfa.bancodefilmes.compose.info_filme

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.malfa.bancodefilmes.MainViewModel
import com.malfa.bancodefilmes.R

@Composable
fun InfoFragment( viewModel : MainViewModel){
    Row() {
        Spacer(modifier = Modifier.height(30.dp))
        AsyncImage(model = viewModel.filmes.Poster, contentDescription = stringResource(id = R.string.poster_content_description) + viewModel.filmes.Title)
        Spacer(modifier = Modifier.height(15.dp))
        Row {
            //todo infos importantes, e em seguida um saiba mais, mudar a fonte para ter mais
            // customização
            Text(text = stringResource(id = R.string.titulo_info) + viewModel.filmes.Title)
            Text(text = stringResource(id = R.string.genero_info) + viewModel.filmes.Genre)
            Text(text = stringResource(id = R.string.rated_info) + viewModel.filmes.Rated)
            Text(text = stringResource(id = R.string.lancado_info) + viewModel.filmes.Released)
            Text(text = stringResource(id = R.string.ano_info) + viewModel.filmes.Year)

            Text(text = stringResource(id = R.string.saiba_mais))

            Text(text = stringResource(id = R.string.ano_info) + viewModel.filmes.Plot)
            Text(text = stringResource(id = R.string.ano_info) + viewModel.filmes.Director)
            Text(text = stringResource(id = R.string.ano_info) + viewModel.filmes.Writer)
            Text(text = stringResource(id = R.string.ano_info) + viewModel.filmes.Actors)
            Text(text = stringResource(id = R.string.ano_info) + viewModel.filmes.Runtime)
            Text(text = stringResource(id = R.string.ano_info) + viewModel.filmes.Language)
            Text(text = stringResource(id = R.string.ano_info) + viewModel.filmes.Country)
            Text(text = stringResource(id = R.string.ano_info) + viewModel.filmes.Awards)
            Text(text = stringResource(id = R.string.ano_info) + viewModel.filmes.Ratings)
            Text(text = stringResource(id = R.string.ano_info) + viewModel.filmes.Metascore)
            Text(text = stringResource(id = R.string.ano_info) + viewModel.filmes.imdbRating)
            Text(text = stringResource(id = R.string.ano_info) + viewModel.filmes.imdbID)
            Text(text = stringResource(id = R.string.ano_info) + viewModel.filmes.Type)
            Text(text = stringResource(id = R.string.ano_info) + viewModel.filmes.DVD)
            Text(text = stringResource(id = R.string.ano_info) + viewModel.filmes.BoxOffice)
            Text(text = stringResource(id = R.string.ano_info) + viewModel.filmes.Production)
            Text(text = stringResource(id = R.string.ano_info) + viewModel.filmes.Website)
        }
    }
}