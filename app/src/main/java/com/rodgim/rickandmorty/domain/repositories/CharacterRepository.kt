package com.rodgim.rickandmorty.domain.repositories

import com.rodgim.rickandmorty.domain.entities.Characters

interface CharacterRepository {
    suspend fun getCharacters(): Result<Characters>
}