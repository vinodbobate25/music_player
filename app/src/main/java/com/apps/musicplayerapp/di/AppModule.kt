package com.apps.newsapp.di


import android.content.Context
import androidx.room.Room
import com.apps.musicplayerapp.data.api.ApiHelper
import com.apps.musicplayerapp.data.api.ApiHelperImpl
import com.apps.musicplayerapp.data.api.MusicApiService
import com.apps.musicplayerapp.local.MusicDatabase
import com.mindorks.example.coroutines.data.local.DatabaseHelper
import com.mindorks.example.coroutines.data.local.DatabaseHelperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    private val BASE_URL:String="https://api.itmwpb.com/nowplaying/v3/935/"


    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
       return  Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(MusicApiService::class.java)!!

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper= apiHelper


    private var INSTANCE: MusicDatabase? = null

    @Provides
    @Singleton
    fun getContext(@ApplicationContext context: Context):Context=context


    @Provides
    @Singleton
    fun getInstance(@ApplicationContext context: Context): MusicDatabase {
       return Room.databaseBuilder(
            context.applicationContext,
            MusicDatabase::class.java,
            "music database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDBHelper(dbHelper: DatabaseHelperImpl): DatabaseHelper = dbHelper
}
