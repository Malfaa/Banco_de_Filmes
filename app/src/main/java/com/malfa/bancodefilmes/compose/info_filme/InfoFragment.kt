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
import com.malfa.bancodefilmes.ui.theme.Typography

@Composable
fun InfoFragment( viewModel : MainViewModel){
    Row() {
        Spacer(modifier = Modifier.height(30.dp))
        AsyncImage(model = viewModel.filmes.Poster, contentDescription = stringResource(id = R.string.poster_content_description) + viewModel.filmes.Title)
        Spacer(modifier = Modifier.height(15.dp))
        Row {
            //todo infos importantes, e em seguida um saiba mais, mudar a fonte para ter mais
            // customização
            Text(text = stringResource(id = R.string.titulo_info) + viewModel.filmes.Title, style = Typography.body1)
            Text(text = stringResource(id = R.string.genero_info) + viewModel.filmes.Genre, style = Typography.body1)
            Text(text = stringResource(id = R.string.rated_info) + viewModel.filmes.Rated, style = Typography.body1)
            Text(text = stringResource(id = R.string.lancado_info) + viewModel.filmes.Released, style = Typography.body1)
            Text(text = stringResource(id = R.string.ano_info) + viewModel.filmes.Year, style = Typography.body1)

            Text(text = stringResource(id = R.string.saiba_mais), style = Typography.body1)

            Text(text = stringResource(id = R.string.plot_info) + viewModel.filmes.Plot, style = Typography.body1)
            Text(text = stringResource(id = R.string.director_info) + viewModel.filmes.Director, style = Typography.body1)
            Text(text = stringResource(id = R.string.writer_info) + viewModel.filmes.Writer, style = Typography.body1)
            Text(text = stringResource(id = R.string.actors_info) + viewModel.filmes.Actors, style = Typography.body1)
            Text(text = stringResource(id = R.string.runtime_info) + viewModel.filmes.Runtime, style = Typography.body1)
            Text(text = stringResource(id = R.string.language_info) + viewModel.filmes.Language, style = Typography.body1)
            Text(text = stringResource(id = R.string.country_info) + viewModel.filmes.Country, style = Typography.body1)
            Text(text = stringResource(id = R.string.awards_info) + viewModel.filmes.Awards, style = Typography.body1)
            Text(text = stringResource(id = R.string.ratings_info) + viewModel.filmes.Ratings, style = Typography.body1)
            Text(text = stringResource(id = R.string.metascore_info) + viewModel.filmes.Metascore, style = Typography.body1)
            Text(text = stringResource(id = R.string.imdb_rating_info) + viewModel.filmes.imdbRating, style = Typography.body1)
            Text(text = stringResource(id = R.string.imdb_id_info) + viewModel.filmes.imdbID, style = Typography.body1)
            Text(text = stringResource(id = R.string.type_info) + viewModel.filmes.Type, style = Typography.body1)
            Text(text = stringResource(id = R.string.dvd_info) + viewModel.filmes.DVD, style = Typography.body1)
            Text(text = stringResource(id = R.string.box_office_info) + viewModel.filmes.BoxOffice, style = Typography.body1)
            Text(text = stringResource(id = R.string.production_info) + viewModel.filmes.Production, style = Typography.body1)
            Text(text = stringResource(id = R.string.website_info) + viewModel.filmes.Website, style = Typography.body1)
        }
    }
}