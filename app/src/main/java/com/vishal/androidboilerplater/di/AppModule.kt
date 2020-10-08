package com.vishal.androidboilerplater.di

import android.app.Application
import android.content.Context
import com.vishal.androidboilerplater.data.local.SessionManager
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideSessionManagerModule(@ApplicationContext context: Context): SessionManager {
        return SessionManager(context)
    }

}