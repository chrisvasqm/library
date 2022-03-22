package com.example.library.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReadLaterViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is read later Fragment"
    }
    val text: LiveData<String> = _text
}