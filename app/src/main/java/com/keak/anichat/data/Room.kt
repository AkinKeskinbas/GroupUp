package com.keak.anichat.data

data class Room(
    val boosted: Boolean?,
    val isLimitedRoom: Boolean?,
    val isOwner: Boolean?,
    val isRoomFull: Boolean?,
    val isSpecialChatRoom: Boolean?,
    val ownerImage: String?,
    val ownerName: String?,
    val roomId: String?,
    val subs: List<Sub?>?,
    val title: String?,
    val userLimit: Int?
)