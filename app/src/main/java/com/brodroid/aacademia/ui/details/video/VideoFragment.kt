package com.brodroid.aacademia.ui.details.video

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.brodroid.aacademia.R
import com.brodroid.aacademia.ui.details.LessonData
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class VideoFragment : Fragment(R.layout.fragment_video) {

    private val videoUrl: String by lazy { LessonData.currentLesson?.youtube_id.toString() }

    private lateinit var viewModel: VideoViewModel

    private lateinit var youTubePlayerView: YouTubePlayerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        youTubePlayerView = view.findViewById(R.id.youtube_player_view)
        lifecycle.addObserver(youTubePlayerView)

        viewModel = ViewModelProvider(this).get(VideoViewModel::class.java)
        viewModel.checkWhatShowToUser(videoUrl)
        viewModel.onReadyToShow.observe(viewLifecycleOwner) { showYouTubeVideo(videoUrl) }
        viewModel.onEmptyUrl.observe(viewLifecycleOwner) {
            view.findViewById<TextView>(R.id.emptyMessage).isVisible = true
        }
    }

    private fun showYouTubeVideo(videoUrl: String) {
        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(videoUrl, 0F)
            }
        })
    }

}