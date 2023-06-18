package com.malfa.bancodefilmes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.malfa.bancodefilmes.compose.MainFragment
import com.malfa.bancodefilmes.compose.NavGraph
import com.malfa.bancodefilmes.ui.theme.BancoDeFilmesTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BancoDeFilmesTheme {
                navController = rememberNavController()
                val viewModel : MainViewModel = koinViewModel()
                val filme by viewModel.filme.observeAsState()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainFragment(navController, viewModel = viewModel, filme = filme)
                    NavGraph(navController = navController, viewModel = viewModel, filme = filme)
                }
            }
        }
    }
}

// TODO: arrumar screen size
// TODO: preview e testes dos composables

//fazer 2 composables, um do botão no main e o outro a lista com os filmes pesquisados, tipo histórico