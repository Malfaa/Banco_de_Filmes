package com.malfa.bancodefilmes.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.malfa.bancodefilmes.MainViewModel
import com.malfa.bancodefilmes.compose.cartaz.PosterFragment
import com.malfa.bancodefilmes.compose.cartaz.SearchFragment
import com.malfa.bancodefilmes.ui.theme.background
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainFragment ( modifier: Modifier = Modifier, viewModel : MainViewModel = koinViewModel() ){
    Column (modifier = modifier
        .background(background)
    ){
        PosterFragment(modifier, viewModel)
        SearchFragment(modifier, viewModel)
    }

}