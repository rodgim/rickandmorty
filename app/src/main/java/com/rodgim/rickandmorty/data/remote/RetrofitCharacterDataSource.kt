package com.rodgim.rickandmorty.data.remote

import com.rodgim.rickandmorty.data.datasources.CharacterDataSource
import com.rodgim.rickandmorty.domain.entities.Characters
import javax.inject.Inject

class RetrofitCharacterDataSource @Inject constructor(
    private val api: RickAndMortyApi
) : CharacterDataSource {
    override suspend fun getCharacters(): Result<Characters> {
        return try {
            val result = api.getCharacters()
            return if (result.isSuccessful) {
                Result.success(result.body() ?: Characters())
            } else {
                Result.failure(Exception(result.message()))
            }
        }catch (e: Exception) {
            Result.failure(e)
        }
    }
}