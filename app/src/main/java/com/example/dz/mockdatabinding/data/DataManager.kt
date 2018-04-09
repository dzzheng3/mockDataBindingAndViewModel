package com.example.dz.mockdatabinding.data

import com.example.dz.mockdatabinding.data.model.Item
import java.util.*

class DataManager {
    fun generateList(): List<Item> {
        val mutableListOf = mutableListOf<Item>()
        for (i in 0..10) {
            mutableListOf.add(Item("test" + i, Date()))
        }
        return mutableListOf
    }
}