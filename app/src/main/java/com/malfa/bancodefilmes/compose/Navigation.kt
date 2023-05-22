package com.malfa.bancodefilmes.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.malfa.bancodefilmes.compose.info_filme.InfoFragment

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination =  "main") {
        composable("main") {
            MainFragment(nav = navController)
        }
        composable(
            "info",
            arguments = listOf(
                navArgument("nome"){type = NavType.StringType},
                navArgument()
            )
        ) { InfoFragment()}
    }
}