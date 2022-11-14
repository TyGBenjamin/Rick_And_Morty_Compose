package com.example.rickandmortycompose.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rickandmortycompose.model.entity.RickChar
import com.example.rickandmortycompose.view.CharCard2
import com.example.rickandmortycompose.view.EpisodeDetail
import com.example.rickandmortycompose.view.HomeScreen
import com.example.rickandmortycompose.view.LocationDetail

@SuppressLint("SuspiciousIndentation")
@Composable
fun NavGraph(list: List<RickChar>) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Constants.homeScreen) {
        composable(Screens.Constants.homeScreen) {
            HomeScreen(characters = list, navController = navController)
        }
        composable("character/{id}") {
            val id = it.arguments?.getString("id")

            id?.let { it1 ->
                val episodeIDh = list[it1.toInt() - 1].episode[0].last()
                println("THIS IS SHOWING AS $episodeIDh")
                CharCard2(character = list[it1.toInt() - 1],
                    navigate = { navController.navigate(Screens.Constants.homeScreen) },
                    navigateEpisode = { navController.navigate("episode/${episodeIDh}") })
            }
        }

        composable(Screens.Constants.charLocation) {
            val id = it.arguments?.getString("id")
            id?.let { it1 ->
                LocationDetail(
                    navigate =
                    { navController.navigate(Screens.Constants.homeScreen) }, id = it1
                )
            }
            if (id != null) {
                LocationDetail(
                    navigate = { navController.navigate(Screens.Constants.homeScreen) },
                    id = id
                )
                println("ID IS HERE FOR Location CHECK TO SEEEEEEEEEE ${id}")

            }
        }

        composable(Screens.EpisodeScreen.route, arguments = listOf(navArgument("id") {
            type = NavType.StringType
        })) {
            val id = it.arguments?.getString("id")
            id?.let { it1 ->
                EpisodeDetail(
                    navigate =
                    { navController.navigate(Screens.Constants.homeScreen) }, id = it1
                )
            }
            if (id != null) {
                EpisodeDetail(
                    navigate = { navController.navigate(Screens.Constants.homeScreen) },
                    id = id
                )
                println("ID IS HERE FOR EPISODE CHECK TO SEEEEEEEEEE ${id}")
            }
        }
    }
}
