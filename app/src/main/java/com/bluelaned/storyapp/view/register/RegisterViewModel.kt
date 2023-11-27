package com.bluelaned.storyapp.view.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bluelaned.storyapp.data.database.StoryRepository
import com.bluelaned.storyapp.Response.RegisterResponse
import com.bluelaned.storyapp.data.di.Event
import kotlinx.coroutines.launch

class RegisterViewModel (private val repository: StoryRepository) : ViewModel() {
    val registerResponse: LiveData<RegisterResponse> = repository.registerResponse
    val toastText: LiveData<Event<String>> = repository.toastText

    fun postRegister(name: String, email: String, password: String) {
        viewModelScope.launch {
            repository.postRegister(name, email, password)
        }
    }
}