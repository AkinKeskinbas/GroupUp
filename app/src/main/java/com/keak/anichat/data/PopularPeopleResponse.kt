package com.keak.anichat.data

data class PopularPeopleResponse(
    val popularPeopleList:List<PopularPeople>?
)
data class PopularPeople(
    val userName:String?,
    val userPhoto:String?
)
