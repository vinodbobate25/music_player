package com.apps.newsapp.data

import com.apps.musicplayerapp.data.api.ApiHelper
import com.mindorks.example.coroutines.data.local.DatabaseHelper
import javax.inject.Inject

class MusicRepository @Inject constructor(private  val apiHelper: ApiHelper,private  val dbHelper: DatabaseHelper) {

    //if connected to network fetch from api else fetch from room db
    suspend fun getMusic(isNetworkAvailable:Boolean)=if(isNetworkAvailable) apiHelper.getMusicList()else dbHelper.getCurrentMusic()
}