package com.kietnguyen.roomperson.dao

import androidx.room.*
import com.kietnguyen.roomperson.model.Person
import com.kietnguyen.roomperson.model.PersonWithCompany

@Dao
interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPerson(person: Person): Long

    @Query("SELECT * FROM Person")
    fun readAllPerson(): List<Person>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPerson(person: Person)

    @Transaction
    @Query("SELECT * FROM Person")
    suspend fun getPersonWithCompany(): List<PersonWithCompany>
}