package com.basakyardim.astronomy_pictures.presentation.apod_list_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.basakyardim.astronomy_pictures.domain.model.AstronomyPictures
import com.basakyardim.astronomy_pictures.util.DEFAULT_IMAGE
import com.basakyardim.astronomy_pictures.util.loadPicture
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSource


@Composable
fun ApodListItem(
    apod: AstronomyPictures,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(120.dp)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Column(
            modifier = modifier.weight(1f)
        ) {
            Row(modifier = modifier.fillMaxWidth()) {
                Text(
                    text = "${apod.title}",
                    style = MaterialTheme.typography.body2,
                    modifier = modifier.weight(2f),
                    color = Color.White,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.width(8.dp))

                Card(
                    modifier = modifier
                        .fillMaxSize()
                        .weight(1f),
                    shape = RoundedCornerShape(5.dp),
                    elevation = 5.dp
                ) {
                    apod.url?.let { url ->
                        if (apod.media_type == "image") {
                            val image = loadPicture(url = url, defaultImage = DEFAULT_IMAGE).value
                            image?.let { img ->
                                Image(
                                    bitmap = img.asImageBitmap(),
                                    contentDescription = "APOD",
                                    modifier = modifier
                                        .fillMaxSize(0.2f),
                                    contentScale = ContentScale.FillBounds

                                )

                            }
                        } else if (apod.media_type == "video") {
                            Box(Modifier.fillMaxSize(0.2f)) {
                                PlayVideo(url = apod.url.toString())
                            }

                        }


                    }

                }
            }

        }


    }
}


@Composable
fun PlayVideo(url: String) {
    /*
    val context = LocalContext.current
    val player = ExoPlayer.Builder(context).build()
    val playerView = StyledPlayerView(context)
    val mediaItem = MediaItem.fromUri(url)
    val playWhenReady by rememberSaveable {
        mutableStateOf(true)
    }
    
    player.setMediaItem(mediaItem)
    playerView.player = player
    
    LaunchedEffect(player) {
        player.prepare()
        player.playWhenReady = playWhenReady
    }
    
    AndroidView(factory = {
        playerView
    })
    */

    val context = LocalContext.current
    val exoplayer = remember {
        ExoPlayer.Builder(context).build().apply {
            val defaultDataSourceFactory = DefaultDataSource.Factory(context)
            val dataSourceFactory: com.google.android.exoplayer2.upstream.DataSource.Factory =
                DefaultDataSource.Factory(
                    context, defaultDataSourceFactory
                )

            val mediaItem = MediaItem.fromUri(url)
            val source =
                ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(mediaItem)

            this.setMediaSource(source)
            this.prepare()
        }
    }
    AndroidView(factory = {
        StyledPlayerView(it).apply {
            player = exoplayer
            (player as ExoPlayer).playWhenReady = true
        }
    })
}