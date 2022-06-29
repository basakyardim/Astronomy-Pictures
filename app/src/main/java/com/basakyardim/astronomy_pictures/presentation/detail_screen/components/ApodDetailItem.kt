package com.basakyardim.astronomy_pictures.presentation.detail_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.basakyardim.astronomy_pictures.domain.model.AstronomyPictures
import com.basakyardim.astronomy_pictures.presentation.apod_list_screen.components.PlayVideo
import com.basakyardim.astronomy_pictures.util.DEFAULT_IMAGE
import com.basakyardim.astronomy_pictures.util.loadPicture

@Composable
fun ApodDetailItem(
    apod: AstronomyPictures
    ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = CenterHorizontally,
    ) {
        Text(
            text = apod.title.toString(),
            color = Color.White,
            textAlign = TextAlign.Center
        )

        apod.url?.let { url ->
            if (apod.media_type == "image") {
                val image = loadPicture(url = url, defaultImage = DEFAULT_IMAGE).value
                image?.let { img ->
                    Image(
                        bitmap = img.asImageBitmap(),
                        contentDescription = "APOD",
                        modifier = Modifier
                            .width(250.dp)
                            .height(250.dp)
                            .align(CenterHorizontally)
                            .padding(top = 20.dp, bottom = 20.dp),
                    )

                }
            }
            if (apod.media_type == "video") {
                Box(
                    modifier = Modifier
                        .width(250.dp)
                        .height(250.dp)
                        .align(CenterHorizontally)
                        .padding(top = 20.dp, bottom = 20.dp)
                ) {
                    PlayVideo(url = apod.url.toString())
                }

            }

        }

        apod.explanation?.let {
            Text(
            text = it,
            fontSize = 12.sp,
            color = Color.White,
            textAlign = TextAlign.Center
            )
        }

    }

}