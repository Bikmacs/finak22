package com.example.pr222

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class MoneyAdapter(private val moneyList: List<MoneyConversion>) : RecyclerView.Adapter<MoneyAdapter.MoneyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoneyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_money, parent, false)
        return MoneyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoneyViewHolder, position: Int) {
        val moneyConversion = moneyList[position]
        holder.bind(moneyConversion)
    }

    override fun getItemCount(): Int {
        return moneyList.size
    }

    class MoneyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val fromCurrencyTextView: TextView = itemView.findViewById(R.id.fromCurrencyTextView)
        private val toCurrencyTextView: TextView = itemView.findViewById(R.id.toCurrencyTextView)
        private val conversionRateTextView: TextView = itemView.findViewById(R.id.conversionRateTextView)
        private val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)

        fun bind(moneyConversion: MoneyConversion) {
            fromCurrencyTextView.text = moneyConversion.fromCurrency
            toCurrencyTextView.text = moneyConversion.toCurrency
            conversionRateTextView.text = moneyConversion.conversionRate.toString()
            dateTextView.text = SimpleDateFormat("dd/MM/yyyy hh:mm", Locale.getDefault()).format(Date(moneyConversion.date))
        }
    }
}
