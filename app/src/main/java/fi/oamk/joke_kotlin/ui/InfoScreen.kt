package fi.oamk.joke_kotlin.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import fi.oamk.joke_kotlin.R
import fi.oamk.joke_kotlin.ui.theme.CustomTheme

@Composable
fun InfoScreen() {
    CustomTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.primaryContainer)
                .shadow(2.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(280.dp)
            ) {
                // Title for the Info screen with an icon next to it
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    // Icon next to the title
                    Icon(
                        imageVector = Icons.Filled.Info, // Use the Info icon from Material Icons
                        contentDescription = stringResource(id = R.string.app_info_title),
                        modifier = Modifier.padding(end = 8.dp), // Space between icon and text
                    )

                    // Title Text
                    Text(
                        text = stringResource(id = R.string.app_info_title),
                        style = MaterialTheme.typography.headlineMedium, // Use a headline style for the title
                    )
                }

                // App Info Content
                Text(
                    text = stringResource(id = R.string.app_info),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
