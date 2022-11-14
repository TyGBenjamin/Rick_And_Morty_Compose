package com.example.rickandmortycompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortycompose.model.entity.RickChar
import com.example.rickandmortycompose.model.repository.RepositoryImpl
import com.example.rickandmortycompose.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {
    private val repo = RepositoryImpl
    private val _rickChar: MutableStateFlow<Resource<List<RickChar>>> = MutableStateFlow(Resource.Loading)
    val rickChar = _rickChar.asStateFlow()

    init {
        println("Hitting init ViewModel")
        getCharacters()
    }

    fun getCharacters(){
        viewModelScope.launch {
            _rickChar.value = repo.getCharacters()
            println("THIS IS VALUE OF FLOW ${repo.getCharacters()}")
        }
    }
}
