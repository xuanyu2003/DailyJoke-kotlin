
package fi.oamk.joke_kotlin.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import fi.oamk.joke_kotlin.R
import fi.oamk.joke_kotlin.ui.theme.CustomTheme
import fi.oamk.joke_kotlin.viewmodel.JokeViewModel

@Composable
fun MainScreen(jokeViewModel: JokeViewModel = viewModel()) {
    val jokeContent by jokeViewModel.jokeContent
    val isLoading by jokeViewModel.isLoading

    LaunchedEffect(Unit) {
        jokeViewModel.fetchRandomJoke()
    }

    CustomTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.primaryContainer) // Set background color for the Box
                .shadow(2.dp),
            contentAlignment = Alignment.Center
        ) {
            // Display loading state or the fetched joke
            if (isLoading) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize() // Fill the available space while centering the content
                ) {
                    CircularProgressIndicator()
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(stringResource(id = R.string.loading), style = MaterialTheme.typography.bodyLarge)
                }
            } else {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(16.dp) // Add padding inside the background

                ) {
                    // Title for the joke section with book icon
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(bottom = 24.dp)
                    ) {

                        Icon(
                            imageVector = Icons.Filled.AccountBox,
                            contentDescription = stringResource(id = R.string.daily_joke_title), // Provide content description for accessibility
                            modifier = Modifier.padding(end = 8.dp), // Space between icon and text
                        )

                        // Title Text
                        Text(
                            text = stringResource(id = R.string.daily_joke_title),
                            style = MaterialTheme.typography.headlineMedium, // Use the correct typography style
                        )
                    }

                    // Joke Content
                    Text(
                        text = jokeContent,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .padding(16.dp)
                            .background(MaterialTheme.colorScheme.primaryContainer)// Padding inside the text background
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    // Button to fetch a new joke, no background here
                    Button(
                        onClick = { jokeViewModel.fetchRandomJoke() },
                        modifier = Modifier.padding(top = 24.dp),
                        shape = RectangleShape
                    ) {
                        Text(stringResource(id = R.string.get_random_joke))
                    }
                }
            }
        }
    }
}
