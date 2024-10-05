package cl.noemi.herodaggermvi.data.implementation

import cl.noemi.herodaggermvi.data.network.ApiResponseState
import cl.noemi.herodaggermvi.data.network.ApiServiceHero
import cl.noemi.herodaggermvi.data.network.doNetworkCall
import cl.noemi.herodaggermvi.domain.mapper.HeroMapper
import cl.noemi.herodaggermvi.domain.model.SuperHero
import cl.noemi.herodaggermvi.domain.repository.HeroRepository
import javax.inject.Inject

class HeroRepositoryImpl @Inject constructor(
    private val apiServiceHero: ApiServiceHero
): HeroRepository {
    override suspend fun getSuperHero(): ApiResponseState<List<SuperHero>> {
        return doNetworkCall {
            val response = apiServiceHero.getHeroes()
            val mapper = HeroMapper()
            mapper.dtoToSuperHero(response)
        }
    }
}