package com.example.dz.mockdatabinding.data

import android.arch.persistence.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

class Converters {
    val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA)

    /**
     * String to Date
     */
    @TypeConverter
    fun fromTimestamp(value: String?): Date {
        if (value == null) {
            return Date(System.currentTimeMillis())
        }
        synchronized(format) {
            return format.parse(value)
        }
    }

    /**
     * date to string
     */
    @TypeConverter
    fun dateToTimestamp(date: Date?): String {
        if (date == null) {
            val nowDate = Date(System.currentTimeMillis())
            synchronized(format) {
                return format.format(nowDate)
            }
        }
        synchronized(format) {
            return format.format(date)
        }
    }
}