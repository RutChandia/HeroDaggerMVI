package cl.noemi.herodaggermvi.data.network


import cl.noemi.herodaggermvi.data.dto.HeroDTO
import retrofit2.http.GET

interface ApiServiceHero {
    @GET("all.json")
    suspend fun getHeroes(): List<HeroDTO>
}