package com.vnazarov.krokkrefactored.utilits.vm

import android.media.MediaPlayer
import android.util.Log
import com.vnazarov.krokkrefactored.R
import com.vnazarov.krokkrefactored.databinding.FragmentCurrentPlaceBinding
import com.vnazarov.krokkrefactored.utilits.BaseViewModel
import kotlinx.coroutines.*

class CurrentPlaceViewModel : BaseViewModel() {

    private var apStatus = "play"
    private val mediaJob = Job()
    private val mediaScope = CoroutineScope(Dispatchers.Main + mediaJob)
    private var mediaPlayer: MediaPlayer? = null

    fun initializeMediaPlayer(url: String, binding: FragmentCurrentPlaceBinding){
        mediaPlayer = MediaPlayer()
        mediaPlayer!!.setDataSource(url)
        mediaPlayer!!.prepare()

        binding.apPlayProgress.max = mediaPlayer!!.duration
        binding.apPlayTimeMax.text = convertToTimerMode(mediaPlayer!!.duration)
    }

    fun playAudio(binding: FragmentCurrentPlaceBinding){
        instructMediaPlayer(binding)
    }

    private fun instructMediaPlayer(binding: FragmentCurrentPlaceBinding) {

        when (apStatus) {

            "pause" -> {
                mediaPlayer!!.pause()
                binding.apPlayButton.setImageResource(R.drawable.ic_play_button)
                apStatus = "continue"

                mediaScope
            }
            "continue" -> {

                mediaPlayer!!.start()
                binding.apPlayButton.setImageResource(R.drawable.ic_pause_button)
                apStatus = "pause"

                mediaScope.launch {
                    progressListener(binding, mediaPlayer!!)
                }
            }
            "play" -> {

                try {

                    mediaPlayer!!.start()

                    mediaScope.launch {
                        progressListener(binding, mediaPlayer!!)
                    }

                    binding.apPlayProgress
                    binding.apPlayButton.setImageResource(R.drawable.ic_pause_button)
                    apStatus = "pause"

                } catch (e: Exception) {
                    Log.e("Media player error", e.message.toString())
                }
            }
        }
    }

    private fun convertToTimerMode(duration: Int): String {
        val minute = duration % (1000 * 60 * 60) / (1000 * 60)
        val seconds = duration % (1000 * 60 * 60) % (1000 * 60) / 1000

        var finalString = ""
        finalString += "$minute:"
        if (seconds < 10) finalString += "0"
        finalString += "$seconds"

        return finalString
    }

    private suspend fun progressListener(binding: FragmentCurrentPlaceBinding, mediaPlayer: MediaPlayer) {
        while (apStatus == "pause") {
            delay(1000)
            binding.apCurrentPlayTime.text = convertToTimerMode(mediaPlayer.currentPosition)
            binding.apPlayProgress.progress = mediaPlayer.currentPosition
        }
    }
}
