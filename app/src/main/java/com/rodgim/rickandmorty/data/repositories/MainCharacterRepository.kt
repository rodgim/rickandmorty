package com.rodgim.rickandmorty.data.repositories

import com.rodgim.rickandmorty.data.datasources.CharacterDataSource
import com.rodgim.rickandmorty.domain.entities.Characters
import com.rodgim.rickandmorty.domain.repositories.CharacterRepository
import javax.inject.Inject

class MainCharacterRepository @Inject constructor(
    private val characterDataSource: CharacterDataSource
) : CharacterRepository {
    override suspend fun getCharacters(): Result<Characters> {
        return characterDataSource.getCharacters()
    }
}