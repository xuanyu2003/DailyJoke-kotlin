package fi.oamk.joke_kotlin.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import fi.oamk.joke_kotlin.R
import fi.oamk.joke_kotlin.model.Joke
import fi.oamk.joke_kotlin.model.JokeApi
import kotlinx.coroutines.launch

class JokeViewModel(application: Application) : AndroidViewModel(application) {
    var jokeContent = mutableStateOf(getApplication<Application>().getString(R.string.loading))
    var isLoading = mutableStateOf(false)
    private var errorMessage = mutableStateOf("")

    private val jokeApi = JokeApi.getInstance(application)

    // Fetch random joke and update state
    fun fetchRandomJoke() {
        isLoading.value = true
        errorMessage.value = ""
        jokeContent.value = ""

        // Launch coroutine to fetch joke
        viewModelScope.launch {
            try {
                // Make the Retrofit call to fetch the random joke
                val response: Joke = jokeApi.getRandomJoke()
                jokeContent.value = response.data.content // Access content from the `data` field
            } catch (e: Exception) {
                // If an error occurs, set the error message from resources
                errorMessage.value = getApplication<Application>()
                    .getString(R.string.fetch_joke_error, e.message)
            } finally {
                isLoading.value = false
            }
        }
    }
}
