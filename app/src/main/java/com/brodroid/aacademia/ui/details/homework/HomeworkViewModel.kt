package com.brodroid.aacademia.ui.details.homework

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeworkViewModel : ViewModel() {

    private val _onReadyToShow = MutableLiveData<Unit>()
    val onReadyToShow: LiveData<Unit> = _onReadyToShow

    private val _onEmptyUrl = MutableLiveData<Unit>()
    val onEmptyUrl: LiveData<Unit> = _onEmptyUrl

    fun checkWhatShowToUser(homeworkUrl: String) {
        if (homeworkUrl.isEmpty()) {
            _onEmptyUrl.value = Unit
        } else {
            _onReadyToShow.value = Unit
        }
    }
}