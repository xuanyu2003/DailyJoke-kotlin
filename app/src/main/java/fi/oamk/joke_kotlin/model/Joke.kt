package fi.oamk.joke_kotlin.model


// Define the data model for Joke
data class Joke(
    var statusCode: Int,
    var message: String,
    var data: JokeData
)

data class JokeData(
    var id: Int,
    var content: String
)