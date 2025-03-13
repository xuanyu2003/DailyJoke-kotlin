
package fi.oamk.joke_kotlin.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.*
import fi.oamk.joke_kotlin.R
import fi.oamk.joke_kotlin.ui.theme.CustomTheme // Import the custom theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomTheme {
                AppWithTabs()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppWithTabs() {
    val navController = rememberNavController()
    var selectedTab by remember { mutableIntStateOf(0) }

    // Fetch tab titles from strings.xml
    val tabTitles = listOf(
        stringResource(id = R.string.jokes_tab),
        stringResource(id = R.string.info_tab)
    )
    val tabRoutes = listOf(
        stringResource(R.string.route_main),
        stringResource(R.string.route_info)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(stringResource(id = R.string.top_app_bar_title))
                    }
                }
            )
        },
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            TabRow(selectedTabIndex = selectedTab) {
                tabTitles.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTab == index,
                        onClick = {
                            selectedTab = index
                            navController.navigate(tabRoutes[index])
                        },
                        text = { Text(title,) }
                    )
                }
            }

            NavHost(
                navController = navController,
                startDestination = "main",
                modifier = Modifier.weight(1f)
            ) {
                composable("main") { MainScreen() }
                composable("info") { InfoScreen() }
            }
        }
    }
}
