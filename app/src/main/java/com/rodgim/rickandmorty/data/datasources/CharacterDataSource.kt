package com.rodgim.rickandmorty.data.datasources

import com.rodgim.rickandmorty.domain.entities.Characters

interface CharacterDataSource {
    suspend fun getCharacters(): Result<Characters>
}