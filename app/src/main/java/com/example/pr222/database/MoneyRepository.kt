package com.example.pr222.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.pr222.Money
import com.example.pr222.MoneyConversion
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.UUID

class MoneyRepository private constructor(context: Context) {

    private val database: MoneyDataBase = Room.databaseBuilder(
        context.applicationContext,
        MoneyDataBase::class.java,
        DATABASE_NAME
    ).fallbackToDestructiveMigration() // Это удалит базу данных и создаст новую
        .build()

    private val moneyDao = database.MoneyDao()

    suspend fun getMoneys(): List<Money> = withContext(Dispatchers.IO) {
        moneyDao.getMoneys()
    }

    suspend fun getMoney(id: UUID): Money? = withContext(Dispatchers.IO) {
        moneyDao.getMoney(id)
    }

    suspend fun insertMoney(money: Money) = withContext(Dispatchers.IO) {
        moneyDao.insert(money)
    }

    suspend fun insertMoneyConversion(moneyConversion: MoneyConversion) = withContext(Dispatchers.IO) {
        moneyDao.insert(moneyConversion)
    }

    // Измените метод getMoneyConversions на suspend
    suspend fun getMoneyConversions(): List<MoneyConversion> = withContext(Dispatchers.IO) {
        moneyDao.getMoneyConversions()
    }

    companion object {
        private const val DATABASE_NAME = "money_database"
        private var INSTANCE: MoneyRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = MoneyRepository(context)
            }
        }

        fun get(): MoneyRepository {
            return INSTANCE
                ?: throw IllegalStateException("MoneyRepository должен быть инициализирован")
        }
    }
}
