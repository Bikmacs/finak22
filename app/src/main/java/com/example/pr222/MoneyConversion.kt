package com.example.pr222

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "money_conversion")
data class MoneyConversion(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val fromCurrency: String,
    val toCurrency: String,
    val conversionRate: Double,
    val date: Long
)
