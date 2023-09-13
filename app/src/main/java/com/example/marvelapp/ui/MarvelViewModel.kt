package com.example.marvelapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelapp.data.model.Marvel
import com.example.marvelapp.data.model.MarvelItemModel
import com.example.marvelapp.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarvelViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    //Stateflow has to be initialized with the default/initial value
    private val _marvelDetails = MutableStateFlow(MarvelItemModel())
    val marvelDetails: StateFlow<MarvelItemModel> = _marvelDetails

    fun getMarvelDetails() {
        viewModelScope.launch {
            _marvelDetails.value = repository.getMarvelDetails()
        }
    }
}