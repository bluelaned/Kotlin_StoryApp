package com.bluelaned.storyapp.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.bluelaned.storyapp.data.pref.SessionModel
import com.bluelaned.storyapp.data.database.StoryRepository
import com.bluelaned.storyapp.Response.ListStoryItem
import com.bluelaned.storyapp.data.di.Event
import kotlinx.coroutines.launch

class MainViewModel(private val repository: StoryRepository) : ViewModel() {
    val toastText: LiveData<Event<String>> = repository.toastText
    val getListStories: LiveData<PagingData<ListStoryItem>> =
        repository.getStories().cachedIn(viewModelScope)

    fun getSession(): LiveData<SessionModel> {
        return repository.getSession()
    }

    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }
}