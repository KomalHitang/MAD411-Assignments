package com.example.assignment5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ExpenseDetailsActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expense_details)

        val name = intent.getStringExtra("expenseName") ?: "NA"
        val amount = intent.getDoubleExtra("expenseAmount",0.0)
        val date = intent.getStringExtra("expenseDate") ?: "NA"

        val nameText = findViewById<TextView>(R.id.expenseName)
        val amountText = findViewById<TextView>(R.id.expenseAmount)
        val dateText = findViewById<TextView>(R.id.expenseDate)
        val BackButton = findViewById<Button>(R.id.backToHomeButton)

        nameText.text = "Expense Name: $name"
        amountText.text = "Expense Amount: $$amount"
        dateText.text = "Expense Date: $date"

        BackButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}