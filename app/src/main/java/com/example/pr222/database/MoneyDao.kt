package com.example.pr222.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.pr222.Money
import com.example.pr222.MoneyConversion
import java.util.UUID

@Dao
interface MoneyDao {
    @Query("SELECT * FROM money")
    fun getMoneys(): List<Money>

    @Query("SELECT * FROM money WHERE id=(:id)")
    fun getMoney(id: UUID): Money?

    @Insert
    fun insert(money: Money)

    @Insert
    fun insert(moneyConversion: MoneyConversion)


    @Query("SELECT * FROM money_conversion")
    fun getMoneyConversions(): List<MoneyConversion>
}