package com.malfa.bancodefilmes.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.malfa.bancodefilmes.MainViewModel
import com.malfa.bancodefilmes.compose.cartaz.PosterFragment
import com.malfa.bancodefilmes.compose.cartaz.SearchFragment
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainFragment (modifier: Modifier = Modifier, viewModel : MainViewModel = koinViewModel()){
    Column {
        PosterFragment(modifier, viewModel)
        Spacer(modifier = modifier.height(20.dp))
        SearchFragment()
    }

}