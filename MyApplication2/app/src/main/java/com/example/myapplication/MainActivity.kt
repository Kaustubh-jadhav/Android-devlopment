package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val expenses = ArrayList<Double>()
        addExpenseButton.setOnClickListener {
            if (expenseAmount.text.isNotEmpty()) {
                expenses.add(expenseAmount.text.toString().toDouble())
                expenseAmount.text.clear()
                updateExpensesText()
            }
        }

        clearExpensesButton.setOnClickListener {
            expenses.clear()
            updateExpensesText()
        }
    }

     fun updateExpensesText(expenses: Any) {
        if (expenses.isNotEmpty()) {
            val total = expenses.sum()
            expensesText.text = "Total Expenses: $total"
        } else {
            expensesText.text = "No Expenses Added Yet"
        }
    }
}

private fun Any.sum() {

}
private fun Any.isNotEmpty() {

}


