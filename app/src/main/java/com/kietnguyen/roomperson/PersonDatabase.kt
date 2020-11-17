package com.kietnguyen.roomperson

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kietnguyen.roomperson.dao.PersonDao
import com.kietnguyen.roomperson.model.Person

@Database(entities = [Person::class], version = 3)
abstract class PersonDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao

    companion object {
        private var INSTANCE: PersonDatabase? = null

        fun getInstance(context: Context): PersonDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    PersonDatabase::class.java,
                    "person_db"
                ).build()
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}