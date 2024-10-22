package com.example.pr222

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pr222.database.MoneyRepository
import kotlinx.coroutines.launch

class data_base : AppCompatActivity() {

    private lateinit var moneyRecyclerView: RecyclerView
    private var adapter: MoneyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_base)

        moneyRecyclerView = findViewById(R.id.moneyrecyclerview)
        moneyRecyclerView.layoutManager = LinearLayoutManager(this)

        updateUI() // Этот метод должен вызываться
    }

    private fun updateUI() {
        lifecycleScope.launch {
            val moneyRepository = MoneyRepository.get()
            val moneyConversions = moneyRepository.getMoneyConversions()  // Теперь это вызов suspend функции
            Log.d("MyLog", "MoneyConversions: $moneyConversions")
            if (moneyConversions.isEmpty()) {
                Log.d("MyLog", "Нет данных в базе данных")
            } else {
                Log.d("MyLog", "Данные найдены: $moneyConversions")
            }
            adapter = MoneyAdapter(moneyConversions)
            moneyRecyclerView.adapter = adapter
        }
    }

}
