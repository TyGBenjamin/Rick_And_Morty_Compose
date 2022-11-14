package com.example.rickandmortycompose.navigation

sealed class Screens(val route: String){
    object EpisodeScreen: Screens("episode/{id}"){
//        fun passID (id:Int) : String {
//            return "episode/${id}"
//        }
    }
    object Constants{
        const val homeScreen: String = "home_screen"
        const val charLocation: String = "location/{id}"
    }
}
