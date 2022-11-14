package com.example.rickandmortycompose.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.rickandmortycompose.model.entity.RickChar
import com.example.rickandmortycompose.util.Constants
import com.example.rickandmortycompose.util.Resource
import com.example.rickandmortycompose.viewmodel.EpisodeViewModel
import com.example.rickandmortycompose.viewmodel.HomeScreenViewModel

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavController,
    characters: List<RickChar>
) {
    when (viewModel.rickChar.collectAsState().value) {
        is Resource.Error -> ErrorIndicator()
        Resource.Loading -> ProgressIndicator()
        is Resource.Success -> LazyColumn(modifier = Modifier.padding(5.dp)) {
            items(items = characters, key = { chars -> chars.id }) { char ->
                CharCard(
                    character = char,
                    navigate = { navController.navigate("character/${char.id}") },
                    navController = navController
                )
            }
        }
    }

}

@Composable
fun ProgressIndicator() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorIndicator() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Image(
            painter = rememberAsyncImagePainter(Constants.errorImg),
            contentDescription = null,
            modifier = Modifier.size(145.dp)
        )
    }
}


@Composable
fun CharCard(
    character: RickChar, navigate: () -> Unit, navController: NavController
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.Black)
        .clickable {
            navigate()
            println("Card has been CLICKED")
        }
        .padding(5.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 20.dp, start = 10.dp
                )
        ) {
            Image(
                painter = rememberAsyncImagePainter(character.image),
                contentDescription = null,
                modifier = Modifier.size(145.dp)
            )
            Column(modifier = Modifier.padding(start = 15.dp, end = 15.dp)) {
                Text(text = character.name)
                Row() {
                    Text(text = character.episode[0], fontSize = 11.sp)
                }
                Text(text = "Gender: ${character.gender}", fontSize = 11.sp)
                Row {
                    Text(text = "Location: ${character.location.name}", fontSize = 11.sp)
                }
                Text(text = "Origin: ${character.origin.name}", fontSize = 11.sp)
                Column() {
                    Button(onClick = {
                        val id = character.location.url?.lastIndex
                        navController.navigate("location/${id!!}")
                        println("Location Button Clicked location string: ${character.location.url}")
                    }) {
                        Text(text = "Location Details")
                    }
                }

            }
        }
    }
}

@Composable
fun CharCard2(character: RickChar, navigate: () -> Unit, navigateEpisode: () -> Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            navigate()
            println("Card has been CLICKED")
        }
        .padding(5.dp)
        .background(color = Color.Black)
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 20.dp, start = 10.dp
                )
        ) {
            Image(
                painter = rememberAsyncImagePainter(character.image),
                contentDescription = null,
                modifier = Modifier.size(145.dp)
            )
            Column(
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp)
            ) {
                Text(text = character.name)
                Text(text = "First appeared in: ${character.episode[0]}", fontSize = 11.sp)
                Text(text = "Gender: ${character.gender}", fontSize = 11.sp)
                Row {
                    Text(text = "Location: ${character.location.name}", fontSize = 11.sp)
                }
                Text(text = "Origin: ${character.origin.name}", fontSize = 11.sp)
                Row() {
                    Button(onClick = { navigate() }) {
                        Text(text = "Home", fontSize = 10.sp)
                    }
                    Button(onClick = { navigateEpisode() }) {
                        Text(text = "Episode Detail", fontSize = 10.sp)
                    }
                }
            }
        }
    }
}



