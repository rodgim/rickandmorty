package com.rodgim.rickandmorty.ui.models

import com.rodgim.rickandmorty.domain.entities.Character

sealed class MainListUiState {
    data object Loading: MainListUiState()
    data class Success(val data: List<Character>): MainListUiState()
    data class Error(val message: String): MainListUiState()
}