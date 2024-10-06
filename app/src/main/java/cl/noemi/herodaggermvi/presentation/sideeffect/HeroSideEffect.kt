package cl.noemi.herodaggermvi.presentation.sideeffect

import androidx.annotation.StringRes

sealed class HeroSideEffect {
    data class NavigateToDetails(val superHero: Int) : HeroSideEffect()
    data class ShowError(
        @StringRes val messageId: Int,
        val statusMessage: String? = null
    ) : HeroSideEffect()
}