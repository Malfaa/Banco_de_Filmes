package com.malfa.bancodefilmes.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.malfa.bancodefilmes.IMainViewModel
import com.malfa.bancodefilmes.compose.cartaz.ClassificacaoImagem
import com.malfa.bancodefilmes.retrofit.models.Filme

@Composable
fun ListaFilmesFragment(navController: NavController, viewModel: IMainViewModel){

    val lista = viewModel.filmes.observeAsState(listOf()).value
    // BotaoFragment(acao = navController.navigate(Tela.Info.rota), text = "teste")
    Column() {// fazer com que quando o item é selecionado, navega até o infoFrag e dê display do filme
        LazyColumn{
            items(lista.size) { index ->
                ItemDaLista(filme = lista[index])
            }
            //pegar o id do filme e dar display? como fazer funfar isso?
            // o que eu tenho que fazer é, ver como dar display do filme
        }
    }
}

@Composable
fun ItemDaLista(filme: Filme){
    Row() {
        AsyncImage(
            model = filme.Poster,
            contentDescription = null,
            modifier = Modifier
                .height(300.dp)
                .width(300.dp)
        )

        Text(text = filme.Title.toString())

        ClassificacaoImagem(filme = filme)
    }
}

@Preview
@Composable
fun ItemDaListaPreview(){
//    ItemDaLista()
}