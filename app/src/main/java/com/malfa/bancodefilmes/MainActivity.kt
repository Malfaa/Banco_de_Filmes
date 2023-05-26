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
                val filme by viewModel.filmes.observeAsState()
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

// TODO: o que eu posso fazer é um botão no main que tem uma lista de todos os filmes pesquisados
// TODO: arrumar screen size
// TODO: preview e testes dos composables