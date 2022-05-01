package com.miladsh7.youtube.di

import com.miladsh7.youtube.repo.BannerRepository
import com.miladsh7.youtube.repo.BannerRepositoryImpl
import com.miladsh7.youtube.repo.SpecialRepository
import com.miladsh7.youtube.repo.SpecialRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Singleton

@DisableInstallInCheck
@Module(includes = [YoutubeModule::class])
object RepositoryModule {

    @DisableInstallInCheck
    @Module
    interface Bindings{


        @Binds
        @Singleton
        fun provideSpecialRepository(specialRepositoryImpl: SpecialRepositoryImpl):SpecialRepository

        @Binds
        @Singleton
        fun provideBannerRepository(bannerRepositoryImpl: BannerRepositoryImpl):BannerRepository



    }
}