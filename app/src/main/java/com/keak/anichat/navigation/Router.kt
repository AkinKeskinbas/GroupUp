package com.keak.geniusai.navigation


interface Router {
    fun goToSplashScreen()
    fun goToSubScreen()
    fun goToChatHistoryScreen()
    fun goToHomeScreen()
    fun goToIdentifyScreen()
    fun goToChatScreen()
    fun goToCreateImageScreen()
    fun goToDetailScreen(malID: Int)
    fun goToLoginScreen()
    fun goToSignUpScreen()
    fun goToProfileScreen()
    fun goBack()
}