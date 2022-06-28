package com.basakyardim.astronomy_pictures.presentation.detail_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.basakyardim.astronomy_pictures.domain.model.AstronomyPictures
import com.basakyardim.astronomy_pictures.presentation.apod_list_screen.components.PlayVideo
import com.basakyardim.astronomy_pictures.util.DEFAULT_IMAGE
import com.basakyardim.astronomy_pictures.util.LoadPicture

@Composable
fun ApodDetailItem(
    apod: AstronomyPictures
    ) {

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = apod.title.toString())

            Spacer(modifier = Modifier.height(10.dp))

            Column(modifier = Modifier
                .height(250.dp)
                .width(250.dp)) {
                apod.url?.let { url ->
                    if (apod.media_type == "image") {
                        val image = LoadPicture(url = url, defaultImage = DEFAULT_IMAGE).value
                        image?.let { img ->
                            Image(
                                bitmap = img.asImageBitmap(),
                                contentDescription = "APOD",
                                modifier = Modifier
                                    .fillMaxSize(),
                            )

                        }
                    } else if (apod.media_type == "video") {
                        Box(Modifier.fillMaxSize()) {
                            PlayVideo(url = apod.url.toString())
                        }

                    }


                }

            }

            apod.explanation?.let { Text(
                text = it,
                fontSize = 12.sp

            ) }


        }


    }

}