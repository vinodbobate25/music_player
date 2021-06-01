package com.mindorks.example.coroutines.data.local

import com.apps.musicplayerapp.RecentMusic
import com.apps.musicplayerapp.data.model.Music

interface DatabaseHelper {

    suspend fun getCurrentMusic(): List<RecentMusic>

    suspend fun insertCurrent(users: List<RecentMusic>)

}