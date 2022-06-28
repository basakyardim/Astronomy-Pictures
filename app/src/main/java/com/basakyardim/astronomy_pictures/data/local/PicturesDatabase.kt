package com.basakyardim.astronomy_pictures.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.basakyardim.astronomy_pictures.db.PicturesEntity

@Database(entities = [PicturesEntity::class], version = 1)
abstract class PicturesDatabase : RoomDatabase() {

    abstract val dao: PicturesDao

    companion object {
        const val DATABASE_NAME = "apod_database"
    }
}