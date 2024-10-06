package cl.noemi.herodaggermvi.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.noemi.herodaggermvi.presentation.screens.DetailsScreen
import cl.noemi.herodaggermvi.presentation.screens.MainScreen
import cl.noemi.herodaggermvi.presentation.viewmodel.HeroViewModel

@Composable
fun HeroNav(
    viewModel: HeroViewModel = hiltViewModel(),
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = "mainScreen") {
        composable("mainScreen") {
            MainScreen(
                viewModel = viewModel,
                navController = navController
            )
        }
        composable(
            "detailsScreen",
        ) {
            DetailsScreen(viewModel = viewModel)
        }
    }
}