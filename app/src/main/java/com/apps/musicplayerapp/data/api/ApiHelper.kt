package com.apps.musicplayerapp.data.api

import com.apps.musicplayerapp.RecentMusic
import com.apps.musicplayerapp.data.model.Music

interface ApiHelper {
    suspend fun getMusicList():ArrayList<RecentMusic>
}