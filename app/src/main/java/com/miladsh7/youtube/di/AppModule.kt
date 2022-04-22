package com.miladsh7.youtube.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(
    includes = [RepositoryModule::class,
        RepositoryModule.Bindings::class]
)
@InstallIn(SingletonComponent::class)
object AppModule {

}