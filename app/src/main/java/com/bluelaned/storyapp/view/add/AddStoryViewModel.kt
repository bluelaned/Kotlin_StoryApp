package  com.bluelaned.storyapp.view.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bluelaned.storyapp.Response.AddStoryResponse
import com.bluelaned.storyapp.data.database.StoryRepository
import com.bluelaned.storyapp.data.di.Event
import com.bluelaned.storyapp.data.pref.SessionModel
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import okhttp3.RequestBody

class AddStoryViewModel(private val repository: StoryRepository) : ViewModel() {
    val uploadResponse: LiveData<AddStoryResponse> = repository.uploadResponse
    val isLoading: LiveData<Boolean> = repository.isLoading
    val toastText: LiveData<Event<String>> = repository.toastText

    fun uploadStory(token: String, file: MultipartBody.Part, description: RequestBody) {
        viewModelScope.launch {
            repository.uploadStory(token, file, description)
        }
    }

    fun getSession(): LiveData<SessionModel> {
        return repository.getSession()
    }
}