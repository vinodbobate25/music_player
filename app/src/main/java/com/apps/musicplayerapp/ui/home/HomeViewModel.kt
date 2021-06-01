package com.apps.musicplayerapp.ui.home

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apps.musicplayerapp.MusicApp
import com.apps.musicplayerapp.RecentMusic
import com.apps.musicplayerapp.data.model.Music
import com.apps.musicplayerapp.utils.isConnectedToNetwork
import com.apps.newsapp.data.MusicRepository
import com.apps.newsapp.utils.Resource
import com.mindorks.example.coroutines.data.local.DatabaseHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class HomeViewModel@Inject constructor(private val musicRepository: MusicRepository,private val context: Context,private  val dbHelper: DatabaseHelper):ViewModel(){
    private val listlivedata=MutableLiveData<Resource<List<RecentMusic>>>()

    init {
        fetchMusic()
    }

    private  fun fetchMusic()
    {
        viewModelScope.launch {
            listlivedata.postValue(Resource.loading(null))
            try {

                val musicFromAPI=musicRepository.getMusic(context.isConnectedToNetwork())
                if(context.isConnectedToNetwork() && !musicFromAPI.isEmpty())
                dbHelper.insertCurrent(musicFromAPI)
                listlivedata.postValue(Resource.success(musicFromAPI))
            }
            catch (e: Exception)
            {
                listlivedata.postValue(Resource.error("ERROR ouccred "+e.printStackTrace(),null))
            }
        }
    }

    //update music list
    fun getMusiclIst():LiveData<Resource<List<RecentMusic>>>
    {
        return  listlivedata
    }

}