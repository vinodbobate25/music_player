package com.apps.musicplayerapp.data.api

import com.apps.musicplayerapp.RecentMusic
import com.apps.musicplayerapp.data.model.Music
import retrofit2.http.GET

interface MusicApiService {

    @GET("testapi")
    suspend fun getSongsList():ArrayList<RecentMusic>
}