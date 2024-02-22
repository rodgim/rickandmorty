package com.rodgim.rickandmorty.data.remote

import com.rodgim.rickandmorty.domain.entities.Characters
import retrofit2.Response
import retrofit2.http.GET

interface RickAndMortyApi {
    @GET("character")
    suspend fun getCharacters(): Response<Characters>
}