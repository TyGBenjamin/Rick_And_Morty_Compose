package com.example.rickandmortycompose.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.rickandmortycompose.viewmodel.LocationViewModel


@Composable
fun LocationDetail(
    viewModel: LocationViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navigate: () -> Unit,
    id: String
) {
    val result = viewModel.setLocation(id.toInt())
    val locationData = viewModel.location.collectAsState().value
    println(locationData)
    when (locationData) {

        is Resource.Error -> {
            println("HITTING THIS ERROR BLOCK IN EPISDOE DETAILS $locationData")
            ErrorIndicator()
        }
        Resource.Loading -> {
            println("$locationData is stuck in LOADING BLOCK")
            ProgressIndicator()
        }
        is Resource.Success ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
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
                            Constants.setImageTwo
                        ),
                        contentDescription = null,
                        modifier = Modifier.size(145.dp)
                    )
                    Column(modifier = Modifier.padding(start = 15.dp, end = 15.dp)) {
                        Text(text = "Location")
                        Text(text = locationData.data.name)
                        Text(text = "Dimension: ${locationData.data.dimension}")
//                        Row {
//                            LazyColumn(modifier = Modifier.padding(5.dp)) {
//                                items(
//                                    items = locationData.data.residents,
//                                    key = { char -> char }) { char ->
//                                    Text(text = char)
//
//                                }
//                            }
//                        }
                        Button(onClick = { navigate() }) {
                            Text(text = "Home")
                        }
                    }
                }
            }
        else -> {}
    }
}
