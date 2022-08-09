package com.indocyber.testproject.module

import com.indocyber.api_service.service.DataService
import com.indocyber.api_service.usecase.DataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    fun provideDataUseCase(dataService: DataService) = DataUseCase(dataService)
}