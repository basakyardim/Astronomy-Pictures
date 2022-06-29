package com.basakyardim.astronomy_pictures.data.repository

import com.basakyardim.astronomy_pictures.data.local.PicturesDao
import com.basakyardim.astronomy_pictures.data.remote.NasaApi
import com.basakyardim.astronomy_pictures.domain.model.AstronomyPictures
import com.basakyardim.astronomy_pictures.domain.repository.ApodRepository
import com.basakyardim.astronomy_pictures.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class ApodRepositoryImpl @Inject constructor(
    private val api: NasaApi,
    private val dao: PicturesDao
) : ApodRepository {

    override fun getApods(start_date: String): Flow<Resource<List<AstronomyPictures>>> = flow {

        emit(Resource.Loading())
        val pictures = dao.getAllApods().map { it.toAstronomyPictures() }
        emit(Resource.Loading(pictures))

        try {
            val remotePictures = api.fetchPictures(start_date = start_date)
            dao.deleteFromDb()
            dao.insertApods(remotePictures.map { it.toPicturesEntity() })

        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = "Oops, æsomething went wrong!",
                    data = pictures
                )
            )


        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Could not reach the server, check your internet connection!",
                    data = pictures
                )
            )

        }

        val newPictures = dao.getAllApods().map { it.toAstronomyPictures() }
        emit(Resource.Success(newPictures))
    }

    override suspend fun getApodDetail(id: Int): Resource<AstronomyPictures?> {
        val detailInfo = dao.getApodById(id)?.toAstronomyPictures()
        return Resource.Success(detailInfo)
    }
}

