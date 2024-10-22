package com.example.pr222.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.pr222.Money
import com.example.pr222.MoneyConversion

@Database(entities = [Money::class, MoneyConversion::class], version = 2)
@TypeConverters(MoneyTypeConverters::class)
abstract class MoneyDataBase : RoomDatabase() {
    abstract fun MoneyDao(): MoneyDao
}