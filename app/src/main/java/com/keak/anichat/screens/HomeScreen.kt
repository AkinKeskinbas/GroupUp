package com.keak.anichat.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.google.gson.Gson
import com.keak.anichat.components.GroupCard
import com.keak.anichat.components.PopularPeopleCircle
import com.keak.anichat.components.VerticalGroupCard
import com.keak.anichat.data.HomeResponse
import com.keak.anichat.data.PopularPeopleResponse
import com.keak.anichat.data.Room
import com.keak.anichat.util.Misc
import com.keak.geniusai.navigation.Router
import timber.log.Timber
import kotlin.random.Random

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(router: Router) {
    val roomsResponse = Gson().fromJson(Misc.dummy, HomeResponse::class.java)
    val baseRooms = remember {
        mutableStateListOf<Room>()
    }
    val popularPeopleResponse =
        Gson().fromJson(Misc.populerPeopleDummy, PopularPeopleResponse::class.java)

    roomsResponse.rooms?.forEach { room ->
        room?.let { safeRoom ->
            if (safeRoom.boosted == true) {
                baseRooms.add(0, safeRoom)
            } else {
                baseRooms.add(safeRoom)
            }
        }
    }
    val photoList = roomsResponse.rooms?.map {
        it?.subs?.map { subs ->
            subs?.subPhoto.orEmpty()
        }.orEmpty()
    }.orEmpty().flatten()
    val screenWidth = LocalConfiguration.current.screenWidthDp


    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = "Popular", style = MaterialTheme.typography.titleLarge, color = Color.Black)
        LazyRow() {
            items(popularPeopleResponse.popularPeopleList.orEmpty()) { people ->
                PopularPeopleCircle(
                    imageLink = people.userPhoto.orEmpty(),
                    userName = people.userName.orEmpty(),
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.padding(8.dp))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Rooms", style = MaterialTheme.typography.titleLarge, color = Color.Black)
        Spacer(modifier = Modifier.height(16.dp))
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive((screenWidth / 2.7).dp),
            modifier = Modifier
        ) {
            Timber.tag("list").d("Gridview init")
            items(baseRooms) { room ->
                val color = Color(
                    red = Random.nextInt(255),
                    green = Random.nextInt(255),
                    blue = Random.nextInt(255),
                    alpha = 255
                )
                when (room.isSpecialChatRoom) {
                    true -> {
                        VerticalGroupCard(
                            bgColor = color,
                            title = if (room.boosted == true) "Boosted" else room.title.orEmpty(),
                            userName = room.ownerName.orEmpty(),
                            userPhoto = room.ownerImage.orEmpty(),
                            participantsPhotoList = photoList,
                            modifier = Modifier.padding(8.dp)
                        ) {

                        }
                    }

                    else -> {
                        GroupCard(
                            bgColor = color,
                            title = if (room.boosted == true) "Boosted" else room.title.orEmpty(),
                            userName = room.ownerName.orEmpty(),
                            userPhoto = room.ownerImage.orEmpty(),
                            participantsPhotoList = photoList,
                            modifier = Modifier.padding(8.dp)
                        ) {

                        }
                    }
                }
            }
        }
    }
}
