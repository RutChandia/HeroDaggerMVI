package cl.noemi.herodaggermvi.di


import cl.noemi.herodaggermvi.data.implementation.HeroRepositoryImpl
import cl.noemi.herodaggermvi.domain.repository.HeroRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    abstract fun bindHeroRepository(repository: HeroRepositoryImpl): HeroRepository
}
