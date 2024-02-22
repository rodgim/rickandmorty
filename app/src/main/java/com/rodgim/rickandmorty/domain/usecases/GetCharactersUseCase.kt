package com.rodgim.rickandmorty.domain.usecases

import com.rodgim.rickandmorty.domain.repositories.CharacterRepository
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) {
    suspend operator fun invoke() = characterRepository.getCharacters()
}