package cl.noemi.herodaggermvi.presentation.intent

sealed class HeroIntent {
    data object LoadSuperHeroes : HeroIntent()
    data class SelectHero(val heroId: Int) : HeroIntent()
}
