package com.vnazarov.krokkrefactored.utilits.vm

import android.media.MediaPlayer
import android.util.Log
import android.widget.SeekBar
import com.vnazarov.krokkrefactored.R
import com.vnazarov.krokkrefactored.databinding.FragmentCurrentPlaceBinding
import com.vnazarov.krokkrefactored.utilits.BaseViewModel
import kotlinx.coroutines.*

class CurrentPlaceViewModel : BaseViewModel() {

    private var mpStatus = "play"
    private val mediaJob = Job()
    private val mediaScope = CoroutineScope(Dispatchers.Main + mediaJob)
    private var mediaPlayer: MediaPlayer? = null

    private var place: ArrayList<String> = arrayListOf()

    fun setPlace(place: ArrayList<String>?){
        if (place != null){
            this.place = place
        }
    }

    fun getPlace() = place

    fun initializeMediaPlayer(url: String, binding: FragmentCurrentPlaceBinding){

        mpStatus = "play"

        mediaPlayer = MediaPlayer()
        mediaPlayer!!.setDataSource(url)
        mediaPlayer!!.prepare()

        binding.apPlayProgress.max = mediaPlayer!!.duration
        binding.apPlayTimeMax.text = convertToTimerMode(mediaPlayer!!.duration)

        pbListener(binding, mediaPlayer!!)
    }

    fun playAudio(binding: FragmentCurrentPlaceBinding){
        instructMediaPlayer(binding)
    }

    fun mpStop(){
        mpStatus = "stop"

        if (mediaPlayer!!.isPlaying) {
            mediaPlayer!!.stop()
            mediaPlayer!!.release()
        } else mediaPlayer!!.release()
    }

    private fun instructMediaPlayer(binding: FragmentCurrentPlaceBinding) {

        when (mpStatus) {

            "pause" -> {
                mediaPlayer!!.pause()
                binding.apPlayButton.setImageResource(R.drawable.ic_play_button)
                mpStatus = "continue"

                mediaScope
            }
            "continue" -> {

                mediaPlayer!!.start()
                binding.apPlayButton.setImageResource(R.drawable.ic_pause_button)
                mpStatus = "pause"

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
                    mpStatus = "pause"

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
        while (mpStatus == "pause") {
            binding.apCurrentPlayTime.text = convertToTimerMode(mediaPlayer.currentPosition)
            binding.apPlayProgress.progress = mediaPlayer.currentPosition
            delay(1000)
        }
    }

    private fun pbListener(binding: FragmentCurrentPlaceBinding, mediaPlayer: MediaPlayer){
        binding.apPlayProgress.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if (p2) {
                    mediaPlayer.seekTo(p1)
                    binding.apCurrentPlayTime.text = convertToTimerMode(mediaPlayer.currentPosition)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}

        })
    }
}
