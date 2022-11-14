package com.example.rickandmortycompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortycompose.model.entity.Episode
import com.example.rickandmortycompose.model.repository.RepositoryImpl
import com.example.rickandmortycompose.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EpisodeViewModel: ViewModel() {
    private val repo = RepositoryImpl
    private val _episode: MutableStateFlow<Resource<Episode>?> =
        MutableStateFlow(Resource.Loading)
    val episode = _episode.asStateFlow()

    fun setEpisode(id: Int) {
        viewModelScope.launch {
            _episode.value = repo.getEpisodeById(id)
        }
    }
}
