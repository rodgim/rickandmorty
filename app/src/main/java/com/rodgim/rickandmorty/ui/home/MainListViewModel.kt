package com.rodgim.rickandmorty.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodgim.rickandmorty.domain.usecases.GetCharactersUseCase
import com.rodgim.rickandmorty.ui.models.MainListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainListViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {
    private val _mainListUiState: MutableStateFlow<MainListUiState> = MutableStateFlow(MainListUiState.Loading)
    val mainListUiState: StateFlow<MainListUiState> = _mainListUiState.asStateFlow()

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            _mainListUiState.value = MainListUiState.Loading
            getCharactersUseCase()
                .onSuccess {
                    _mainListUiState.value = MainListUiState.Success(it.results)
                }
                .onFailure {
                    _mainListUiState.value = MainListUiState.Error(it.message ?: "Error Loading the data")
                }
        }
    }

    fun reload() {
        getCharacters()
    }
}