package com.kietnguyen.roomperson.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.kietnguyen.roomperson.model.Company

@Dao
interface CompanyDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCompany(company: Company)
}