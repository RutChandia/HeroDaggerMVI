package cl.noemi.herodaggermvi.presentation.viewmodel

import androidx.lifecycle.ViewModel
import cl.noemi.herodaggermvi.data.network.ApiResponseState
import cl.noemi.herodaggermvi.domain.model.SuperHero
import cl.noemi.herodaggermvi.domain.repository.HeroRepository
import cl.noemi.herodaggermvi.presentation.intent.HeroIntent
import cl.noemi.herodaggermvi.presentation.sideeffect.HeroSideEffect
import cl.noemi.herodaggermvi.presentation.state.HeroState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class HeroViewModel @Inject constructor(
    private val repository: HeroRepository
) : ViewModel(), ContainerHost<HeroState, HeroSideEffect> {

    override val container = container<HeroState, HeroSideEffect>(HeroState())

    private val _selectedHero = MutableStateFlow<SuperHero?>(null)
    val selectedHero: StateFlow<SuperHero?> = _selectedHero.asStateFlow()


    init {
        handleIntent(HeroIntent.LoadSuperHeroes)
    }

    fun handleIntent(intent: HeroIntent) {
        when (intent) {
            is HeroIntent.LoadSuperHeroes -> loadSuperHeroes()
            is HeroIntent.SelectHero -> selectHero(intent.heroId)
        }
    }

    private fun loadSuperHeroes() = intent {
        reduce { state.copy(isLoading = true) }
        when (val response = repository.getSuperHero()) {
            is ApiResponseState.Success -> {
                reduce {
                    state.copy(
                        superHeroes = response.data,
                        isLoading = false
                    )
                }
            }

            is ApiResponseState.Error -> {
                postSideEffect(
                    HeroSideEffect.ShowError(
                        messageId = response.messageId,
                        statusMessage = response.statusMessage
                    )
                )
                reduce { state.copy(isLoading = false) }
            }

            is ApiResponseState.Loading -> {
                reduce { state.copy(isLoading = true) }
            }
        }
    }

    private fun selectHero(heroId: Int) = intent {
        val selectedHero = state.superHeroes.find { it.id == heroId }
        reduce { state.copy(selectedHero = selectedHero) }
        selectedHero?.let {
            _selectedHero.value = selectedHero
            postSideEffect(HeroSideEffect.NavigateToDetails(it.id))
        }
    }
}

