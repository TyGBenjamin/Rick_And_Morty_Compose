package com.example.rickandmortycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import com.example.rickandmortycompose.navigation.NavGraph
import com.example.rickandmortycompose.ui.theme.RickAndMortyComposeTheme
import com.example.rickandmortycompose.util.Resource
import com.example.rickandmortycompose.view.ErrorIndicator
import com.example.rickandmortycompose.view.ProgressIndicator
import com.example.rickandmortycompose.viewmodel.HomeScreenViewModel

class MainActivity : ComponentActivity() {
    private val homeViewModel: HomeScreenViewModel =  HomeScreenViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyComposeTheme {
                when(val viewState = homeViewModel.rickChar.collectAsState().value){
                    is Resource.Error -> {println("Hitting This error block")
                    ErrorIndicator()}
                    Resource.Loading -> ProgressIndicator()
                    is Resource.Success -> NavGraph(list = viewState.data)
                }
            }
        }
    }
}

