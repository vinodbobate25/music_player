package com.apps.musicplayerapp.local

import androidx.room.*
import com.apps.musicplayerapp.RecentMusic
import com.apps.musicplayerapp.data.model.Music

@Dao
interface DaoAccess {


    @Query("SELECT * FROM RecentMusic")
    suspend fun getCurrentMusic(): List<RecentMusic>

    @Insert
    suspend fun insertCurrentMusic(songsList: List<RecentMusic>)

    @Delete
    suspend fun deleteAllMusic(currentMusicList: List<RecentMusic>)

}