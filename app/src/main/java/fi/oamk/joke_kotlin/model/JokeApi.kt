package fi.oamk.joke_kotlin.model

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://api.freeapi.app/"

// Define the JokeApi interface for Retrofit
interface JokeApi {
    @GET("api/v1/public/randomjokes/joke/random")
    suspend fun getRandomJoke(): Joke

    companion object {
        private var jokeService: JokeApi? = null

        // Create or return existing instance of JokeApi
        fun getInstance(application: Application): JokeApi {
            if (jokeService == null) {
                jokeService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(JokeApi::class.java)
            }
            return jokeService!!
        }
    }
}

