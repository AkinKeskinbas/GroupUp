package com.keak.geniusai.navigation

sealed class Screens(
    val route: String
){
    object Home : Screens(route = Path.HOME.path)
    object IDENTIFY_SCREEN : Screens(route = Path.IDENTIFY_SCREEN.path)
    object CreateImageScreen : Screens(route = Path.CREATE_IMAGE_SCREEN.path)
    object Splash : Screens(route = Path.SPLASH.path)
    object Detail : Screens(route = Path.DETAIL.path){
        fun passMalID(malID:Int):String{
            return "DETAIL/$malID"
        }
    }

    object SubScreen : Screens(route = Path.SUB_SCREEN.path)
    object ChatHistoryScreen : Screens(route = Path.CHAT_HISTORY_SCREEN.path)
}
object Routes {
    const val HOME = "HOME"
    const val IDENTIFY_SCREEN = "IDENTIFY_SCREEN"
    const val CREATE_IMAGE_SCREEN = "CREATE_IMAGE_SCREEN"
    const val SUB_SCREEN = "SUB_SCREEN"
    const val CHAT_HISTORY_SCREEN = "CHAT_HISTORY_SCREEN"
    const val CHAT = "CHAT"
    const val SHOWCASE = "SHOWCASE/{title}/{malID}"
    const val DETAIL = "DETAIL/{malID}"
    const val MESSAGE_SCREEN = "MESSAGE_SCREEN/{message}/{roomId}/{question}"
    //const val GAME = "GAME_SCREEN/{userId}"
    const val SEARCH = "SEARCH_SCREEN/{categories}/{searchValue}"
    const val SETTINGS = "SETTINGS"
    const val SPLASH = "SPLASH"
    const val LOGIN = "LOGIN"
    const val SIGNUP = "SIGNUP"
    const val PROFILE = "PROFILE"
    const val MY_MESSAGES = "MY_MESSAGES/{writerId}/{messageContent}"
    const val BOARD= "BOARD"
    const val PURCHASE = "PURCHASE"
    const val LANDING = "LANDING"
}
enum class Path(
    val path: String,
    val hasDeeplink:Boolean = false
) {
    HOME(path = Routes.HOME),
    IDENTIFY_SCREEN(path = Routes.IDENTIFY_SCREEN),
    CREATE_IMAGE_SCREEN(path = Routes.CREATE_IMAGE_SCREEN),
    SUB_SCREEN(path = Routes.SUB_SCREEN),
    CHAT_HISTORY_SCREEN(path = Routes.CHAT_HISTORY_SCREEN),
    CHAT(path = Routes.CHAT),
    SHOWCASE(path = Routes.SHOWCASE),
    DETAIL(path = Routes.DETAIL),
    MESSAGE_SCREEN(path = Routes.MESSAGE_SCREEN),
    SEARCH(path = Routes.SEARCH),
    SETTINGS(path = Routes.SETTINGS),
    SPLASH(path = Routes.SPLASH),
    LOGIN(path = Routes.LOGIN),
    SIGNUP(path = Routes.SIGNUP),
    PROFILE(path = Routes.PROFILE),
    MY_MESSAGES(path = Routes.MY_MESSAGES, hasDeeplink = true),
    BOARD(path = Routes.BOARD, hasDeeplink = true),
    PURCHASE(path = Routes.PURCHASE, hasDeeplink = true),
    LANDING(path = Routes.LANDING)
}