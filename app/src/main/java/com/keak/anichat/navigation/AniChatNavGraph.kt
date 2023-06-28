package com.keak.geniusai.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.keak.anichat.screens.HomeScreen
import com.keak.anichat.screens.SplashScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AniChatNavGraph(
    navController: NavHostController,
    router: Router,
    startDestination: String = Screens.Splash.route,
    navGraphBuilder: NavGraphBuilder.() -> Unit = {},
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = startDestination,
        enterTransition = { slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Start) },
        popExitTransition = { slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.Start) }
    ) {
        navGraphBuilder.invoke(this)
        mainNavigation(router)
    }
}

@OptIn(ExperimentalAnimationApi::class)
private fun NavGraphBuilder.mainNavigation(
    router: Router
) {
    composable(
        route = Screens.Splash.route,

        ) {
        SplashScreen(router = router)
    }

    composable(
        route = Screens.Home.route,

        ) {
        HomeScreen(router = router)
    }

//    composable(
//        route = Screens.Detail.route,
//        arguments = listOf(navArgument("malID") {
//            type = NavType.IntType
//            defaultValue = 0
//        })
//    ) { navBackStackEntry ->
//        val malID = navBackStackEntry.arguments?.getInt("malID") ?: 0
//        DetailScreen(router = router, malID = malID)
//    }
}