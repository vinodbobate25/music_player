package com.mindorks.example.coroutines.data.local

import com.apps.musicplayerapp.RecentMusic
import com.apps.musicplayerapp.data.model.Music
import com.apps.musicplayerapp.local.MusicDatabase
import javax.inject.Inject

class DatabaseHelperImpl @Inject constructor(  private val appDatabase: MusicDatabase) : DatabaseHelper {

    override suspend fun getCurrentMusic(): List<RecentMusic> =appDatabase.musicDao().getCurrentMusic()
    override suspend fun insertCurrent(musicList: List<RecentMusic>) =appDatabase.musicDao() .insertCurrentMusic(musicList)

}