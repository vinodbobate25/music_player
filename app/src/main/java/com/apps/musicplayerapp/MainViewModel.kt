package com.apps.musicplayerapp

import androidx.lifecycle.ViewModel
import com.apps.newsapp.data.MusicRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val musicRepository: MusicRepository): ViewModel(){

}