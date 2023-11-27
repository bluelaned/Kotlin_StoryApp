package com.bluelaned.storyapp.view.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bluelaned.storyapp.Response.LoginResponse
import com.bluelaned.storyapp.data.database.StoryRepository
import com.bluelaned.storyapp.data.di.Event
import com.bluelaned.storyapp.data.pref.SessionModel
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: StoryRepository) : ViewModel() {
    val loginResponse: LiveData<LoginResponse> = repository.loginResponse
    val toastText: LiveData<Event<String>> = repository.toastText

    fun postLogin(email: String, password: String) {
        viewModelScope.launch {
            repository.postLogin(email, password)
        }
    }

    fun saveSession(session: SessionModel) {
        viewModelScope.launch {
            repository.saveSession(session)
        }
    }

    fun login() {
        viewModelScope.launch {
            repository.login()
        }
    }
}