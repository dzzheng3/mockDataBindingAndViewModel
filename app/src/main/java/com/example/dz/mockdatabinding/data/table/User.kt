package com.example.dz.mockdatabinding.data.table

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(tableName = "user")
data class User constructor(
        @PrimaryKey(autoGenerate = true)
        var id: Int
) {
    constructor() : this(0)

    var name: String? = null

    var createDate: Date? = null
}