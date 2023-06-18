package com.malfa.bancodefilmes.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.malfa.bancodefilmes.MainViewModel
import com.malfa.bancodefilmes.MainViewModelPreview
import com.malfa.bancodefilmes.R
import com.malfa.bancodefilmes.compose.cartaz.PosterFragment
import com.malfa.bancodefilmes.compose.cartaz.SearchFragment
import com.malfa.bancodefilmes.retrofit.models.Filme
import com.malfa.bancodefilmes.ui.theme.background
import com.malfa.bancodefilmes.utils.Tela

@Composable
fun MainFragment (navController: NavController, modifier: Modifier = Modifier, viewModel: MainViewModel, filme: Filme?){
    Column(
        modifier = modifier.background(background)
    ){
        if (filme != null) {
            PosterFragment(navController, modifier = modifier, filme = filme)
        }
        BotaoFragment(navController.navigate(Tela.Lista.rota), stringResource(id = R.string.historico))
        SearchFragment( modifier, viewModel)

        //novoFragment
    }
}

@Preview
@Composable
fun MainPreview(modifier: Modifier = Modifier){
    val navController = rememberNavController()
    val dummy = Filme(
        1,
        "Ice Age",
        "2012","PG",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,"true")
    Column(
        modifier = modifier.background(background)
    ){
        PosterFragment(navController = navController, modifier = Modifier, filme = dummy)
        SearchFragment(modifier, viewModel = MainViewModelPreview())
    }
}