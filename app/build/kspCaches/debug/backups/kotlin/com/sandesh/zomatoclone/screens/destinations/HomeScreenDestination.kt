package com.sandesh.zomatoclone.screens.destinations

import androidx.annotation.RestrictTo
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.ramcosta.composedestinations.scope.DestinationScope
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainer
import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder
import com.ramcosta.composedestinations.spec.*
import androidx.navigation.navDeepLink
import com.sandesh.zomatoclone.screens.homeScreen.HomeScreen

object HomeScreenDestination : DirectionDestination {
         
    operator fun invoke() = this
    
    @get:RestrictTo(RestrictTo.Scope.SUBCLASSES)
    override val baseRoute = "home_screen"

    override val route = baseRoute
    
    @Composable
    override fun DestinationScope<Unit>.Content(
		dependenciesContainerBuilder: @Composable DependenciesContainerBuilder<Unit>.() -> Unit
    ) {
		HomeScreen(
			navigator = destinationsNavigator
		)
    }
    
}