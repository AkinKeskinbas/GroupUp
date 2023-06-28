package com.keak.anichat.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.animeson.anichat.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroupCard(
    bgColor: Color,
    title: String,
    userName: String,
    userPhoto: String,
    participantsPhotoList: List<String>
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val screenHeight = LocalConfiguration.current.screenHeightDp
    Card(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .width((screenWidth / 2).dp)
            .height((screenHeight / 6).dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = bgColor)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
        ) {
            val (titleText, userNameText, userPhotoRef, participantsRef) = createRefs()
            OverlappingRow(modifier = Modifier.constrainAs(participantsRef) {
                top.linkTo(parent.top)
                bottom.linkTo(userNameText.top)
                start.linkTo(parent.start)
            }) {
                participantsPhotoList.take(9).forEachIndexed { index, photoLink ->
                    AsyncImage(
                        model = R.mipmap.ic_launcher,
                        contentDescription = null,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(30.dp)
                            .background(color = Color.White),
                        contentScale = ContentScale.Crop
                    )
                }
                if (participantsPhotoList.size > 9) {
                    val maxParticipantsSize = 99
                    val realSize = participantsPhotoList.size
                    OverlappingMoreBox(if (realSize >= maxParticipantsSize) maxParticipantsSize else realSize)
                }
            }

            Text(
                text = userName,
                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Light),
                color = Color.White,
                modifier = Modifier.constrainAs(userNameText) {
                    bottom.linkTo(titleText.top, margin = 8.dp)
                    start.linkTo(parent.start)
                })
            AsyncImage(
                model = R.mipmap.ic_launcher,
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(50.dp)
                    .background(color = Color.White)
                    .constrainAs(userPhotoRef) {
                        top.linkTo(userNameText.top)
                        bottom.linkTo(titleText.bottom)
                        end.linkTo(parent.end)
                    },
                contentScale = ContentScale.Crop
            )
            val maxLength = 9
            val annotatedString = buildAnnotatedString {
                if (title.length > maxLength) {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(title.substring(0, maxLength))
                    }
                    append("...")
                } else {
                    append(title)
                }
            }
            Text(
                text = annotatedString,
                style = MaterialTheme.typography.titleLarge,
                color = Color.White,
                modifier = Modifier.constrainAs(titleText) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                },
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun GroupCardPreview() {
    GroupCard(
        bgColor = Color.Red,
        title = "PetsPetsPets",
        userName = "WanHeda",
        userPhoto = "",
        participantsPhotoList = listOf("", "", "", "", "", "", "", "", "", "", "", "")
    )
}