package com.example.pr222

import android.app.Application
import com.example.pr222.database.MoneyRepository

class MoneyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        MoneyRepository.initialize(this)
    }
}
