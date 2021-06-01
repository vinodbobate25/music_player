package com.apps.musicplayerapp.data.api

import com.apps.musicplayerapp.RecentMusic
import com.apps.musicplayerapp.data.model.Music
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private  val musicApiService: MusicApiService): ApiHelper {
    override suspend fun getMusicList(): ArrayList<RecentMusic> =musicApiService.getSongsList()


}