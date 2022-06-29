package com.basakyardim.astronomy_pictures.di

import android.app.Application
import androidx.room.Room
import com.basakyardim.astronomy_pictures.data.local.PicturesDatabase
import com.basakyardim.astronomy_pictures.data.remote.NasaApi
import com.basakyardim.astronomy_pictures.data.repository.ApodRepositoryImpl
import com.basakyardim.astronomy_pictures.domain.repository.ApodRepository
import com.basakyardim.astronomy_pictures.domain.use_case.ApodListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGetApodsUseCase(repository: ApodRepository): ApodListUseCase {
        return ApodListUseCase(repository = repository)
    }

    @Provides
    @Singleton
    fun provideApodRepository(
        db: PicturesDatabase,
        api: NasaApi
    ): ApodRepository {
        return ApodRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideDatabase(app: Application): PicturesDatabase {
        return Room.databaseBuilder(
            app,
            PicturesDatabase::class.java,
            PicturesDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNasaApi(): NasaApi {

        return Retrofit.Builder()
            .baseUrl(NasaApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NasaApi::class.java)
    }


}
