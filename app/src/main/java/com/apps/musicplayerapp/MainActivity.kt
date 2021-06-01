package com.apps.musicplayerapp

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.player_tab.*
import java.io.IOException


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var isMediaPlaying: Boolean=false
    private lateinit var mainViewModel: MainViewModel
    var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel =
            ViewModelProvider(this).get(MainViewModel::class.java)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_recent))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        img_play.setOnClickListener {
            if(!isMediaPlaying) {
                img_play.background=resources.getDrawable(R.drawable.ico_pause)
                playAudio()
            }
            else{
                img_play.background=resources.getDrawable(R.drawable.ico_play)

            }
        }
        img_prev.setOnClickListener {

        }
        img_next.setOnClickListener {

        }
    }

    private fun playAudio() {
        val audioUrl = "https://rfcmedia.streamguys1.com/70hits.aac"
        // initializing media player
        mediaPlayer = MediaPlayer()

        // below line is use to set the audio
        // stream type for our media player.
        mediaPlayer?.setAudioStreamType(AudioManager.STREAM_MUSIC)

        // below line is use to set our
        // url to our media player.
        try {
            mediaPlayer?.setDataSource(audioUrl)
            // below line is use to prepare
            // and start our media player.
            mediaPlayer?.prepare()
            mediaPlayer?.start()
            isMediaPlaying=true;
        } catch (e: IOException) {
            e.printStackTrace()
        }
        // below line is use to display a toast message.
        Toast.makeText(this, "Audio started playing..", Toast.LENGTH_SHORT).show()
    }
}