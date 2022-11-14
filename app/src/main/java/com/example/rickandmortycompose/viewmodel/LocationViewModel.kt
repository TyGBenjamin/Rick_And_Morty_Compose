package com.example.rickandmortycompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortycompose.model.entity.LocationDetails
import com.example.rickandmortycompose.model.repository.RepositoryImpl
import com.example.rickandmortycompose.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LocationViewModel: ViewModel() {
    private val repo = RepositoryImpl
    private val _location: MutableStateFlow<Resource<LocationDetails>?> =
        MutableStateFlow(Resource.Loading)
    val location = _location.asStateFlow()

    fun setLocation(id: Int) {
        viewModelScope.launch {
            _location.value = repo.getLocationById(id)
        }
    }
}
