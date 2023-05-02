package com.malfa.bancodefilmes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.malfa.bancodefilmes.compose.MainFragment
import com.malfa.bancodefilmes.ui.theme.BancoDeFilmesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BancoDeFilmesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainFragment()
                }
            }
        }
    }
}
// todo o que eu posso fazer é pegar a resposta em json que a api retorna, passar como resposta
//  pro database, assim ele pega e coloca sem nenhum tipo de erro. A questão é, como fazer um parse
//   simples pro database? Problema ta no koin pra iniciar o DB, isso deve estar acontecendo pq
//  o db não tem info inicial



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BancoDeFilmesTheme {
        MainFragment()
    }
}