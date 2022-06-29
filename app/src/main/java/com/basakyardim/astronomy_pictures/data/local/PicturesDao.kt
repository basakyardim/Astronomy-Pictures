package com.basakyardim.astronomy_pictures.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PicturesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertApods(pictures: List<PicturesEntity>)

    @Query("SELECT * from pictures WHERE id = :id")
    suspend fun getApodById(id: Int): PicturesEntity?

    @Query("SELECT * from pictures")
    suspend fun getAllApods(): List<PicturesEntity>

    @Query("DELETE from pictures")
    suspend fun deleteFromDb()
}