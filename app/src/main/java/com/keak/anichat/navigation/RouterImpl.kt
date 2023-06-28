package com.keak.geniusai.navigation

import androidx.navigation.NavHostController

class RouterImpl(
    private val navHostController: NavHostController,
    private val startDestination: String = Routes.SPLASH
) : Router {


    private fun navigate(
        screen: Screens,
        removeFromHistory: Boolean = false,
        singleTop: Boolean = false
    ) {
        navHostController.apply {
            navigate(screen.route) {
                if (removeFromHistory) {
                    if (singleTop) {
                        popUpTo(screen.route) {
                            inclusive = true
                        }
                    } else {
                        popUpTo(0) {
                            saveState = false
                        }
                    }

                } else {
                    restoreState = true
                }
                launchSingleTop = singleTop
            }
        }
    }

    private fun navigateArg(
        route: String,
        removeFromHistory: Boolean = false,
        singleTop: Boolean = false
    ) {
        navHostController.apply {
            navigate(route = route) {
                if (removeFromHistory) {
                    if (singleTop) {
                        popUpTo(Screens.Home.route)
                    } else {
                        popUpTo(0) {
                            saveState = false
                        }
                    }

                } else {
                    restoreState = true
                }
                launchSingleTop = singleTop
            }
        }
    }


    override fun goToSplashScreen() {

    }

    override fun goToSubScreen() {
        navigate(Screens.SubScreen)
    }

    override fun goToChatHistoryScreen() {
        navigate(Screens.ChatHistoryScreen)
    }

    override fun goToHomeScreen() {
        navigate(Screens.Home)
    }

    override fun goToIdentifyScreen() {
        navigate(Screens.IDENTIFY_SCREEN)
    }

    override fun goToChatScreen() {

    }

    override fun goToCreateImageScreen() {
        navigate(Screens.CreateImageScreen)
    }

    override fun goToDetailScreen(malID: Int) {

    }


    override fun goToLoginScreen() {

    }

    override fun goToSignUpScreen() {

    }

    override fun goToProfileScreen() {

    }

    override fun goBack() {
        navHostController.apply {
            popBackStack()
        }
    }

}