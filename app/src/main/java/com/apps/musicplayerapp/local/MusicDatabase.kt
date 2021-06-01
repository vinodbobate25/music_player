package com.apps.musicplayerapp.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.apps.musicplayerapp.RecentMusic
import com.apps.musicplayerapp.data.model.Music

@Database(entities = arrayOf(Music::class,RecentMusic::class), version = 1, exportSchema = false)
abstract  class MusicDatabase:RoomDatabase() {
    abstract fun musicDao(): DaoAccess

}