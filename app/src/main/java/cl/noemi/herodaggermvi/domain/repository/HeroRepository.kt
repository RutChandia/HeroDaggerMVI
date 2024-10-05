package cl.noemi.herodaggermvi.domain.repository

import cl.noemi.herodaggermvi.data.network.ApiResponseState
import cl.noemi.herodaggermvi.domain.model.SuperHero

interface HeroRepository {
    suspend fun getSuperHero() : ApiResponseState<List<SuperHero>>
}