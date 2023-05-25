package com.malfa.bancodefilmes.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.malfa.bancodefilmes.MainViewModel
import com.malfa.bancodefilmes.compose.info_filme.InfoFragment
import com.malfa.bancodefilmes.retrofit.models.Filme
import com.malfa.bancodefilmes.utils.Tela

@Composable
fun NavGraph(navController: NavHostController, viewModel : MainViewModel, filme: Filme?){

    NavHost(navController = navController, startDestination =  Tela.Main.rota) {
        composable(Tela.Main.rota) {
            MainFragment(viewModel = viewModel, navController = navController, filme = filme)
        }
        composable(
            Tela.Info.rota,
        ) {
            if (filme != null) {
                InfoFragment(filme = filme, navController = navController)
            }
        }
    }

}