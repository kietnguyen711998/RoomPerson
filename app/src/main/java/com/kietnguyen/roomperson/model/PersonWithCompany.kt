package com.kietnguyen.roomperson.model

import androidx.room.Embedded
import androidx.room.Relation

data class PersonWithCompany(
    @Embedded
    val parent: Person,
    @Relation(
        parentColumn = "company_Id",
        entityColumn = "companyId"
    )
    val children: List<Company>
)