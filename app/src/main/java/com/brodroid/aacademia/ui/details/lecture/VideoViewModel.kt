package com.brodroid.aacademia.ui.details.lecture

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VideoViewModel : ViewModel() {

    private val _onReadyToShow = MutableLiveData<Unit>()
    val onReadyToShow: LiveData<Unit> = _onReadyToShow

    private val _onEmptyUrl = MutableLiveData<Unit>()
    val onEmptyUrl: LiveData<Unit> = _onEmptyUrl

    fun checkWhatShowToUser(videoUrl: String) {
        if (videoUrl.isEmpty()) {
            _onEmptyUrl.value = Unit
        } else {
            _onReadyToShow.value = Unit
        }
    }
}