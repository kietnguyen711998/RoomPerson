package com.kietnguyen.roomperson.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Company(
    @PrimaryKey(autoGenerate = true) val companyId: Int?,
    @ColumnInfo(name = "company_Name") val companyName: String?,
    @ColumnInfo(name = "company_Field") val companyField: String?
) : Parcelable