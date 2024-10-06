package cl.noemi.herodaggermvi.presentation.state

import cl.noemi.herodaggermvi.domain.model.SuperHero

data class HeroState(
    val isLoading: Boolean = false,
    val superHeroes: List<SuperHero> = emptyList(),
    val selectedHero: SuperHero? = null,
    val error: String? = null
)