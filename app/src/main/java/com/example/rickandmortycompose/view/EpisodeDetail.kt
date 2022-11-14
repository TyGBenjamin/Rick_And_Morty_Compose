package com.example.rickandmortycompose.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.rickandmortycompose.util.Constants
import com.example.rickandmortycompose.util.Resource
import com.example.rickandmortycompose.viewmodel.EpisodeViewModel

@Composable
fun EpisodeDetail(
    viewModel: EpisodeViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
   navigate:() ->Unit,
    id: String
) {
    val result = viewModel.setEpisode(id.toInt())
    println("result: $id")
    val episodeData = viewModel.episode.collectAsState().value
    println(episodeData)
    when (episodeData) {

        is Resource.Error -> {
            println("HITTING THIS ERROR BLOCK IN EPISDOE DETAILS $episodeData")
            ErrorIndicator()}
        Resource.Loading -> {
            println("$episodeData is stuck in LOADING BLOCK")
            ProgressIndicator()}
        is Resource.Success ->
            Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                }
                .padding(5.dp)
        ) {
            Row(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 20.dp,
                        start = 10.dp
                    )
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        Constants.setImage
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(145.dp)
                )
                Column(modifier = Modifier.padding(start = 15.dp, end = 15.dp)) {
                    (Text(text = "Episode Title"))
                    Text(text = episodeData.data.name)
                    Text(text = "First air date: ${episodeData.data.air_date}")
                    Row {
                    }
                    Button(onClick = { navigate() }) {
                        Text(text = "Home")
                    }
                }
            }
        }
        else -> {}
    }
}




