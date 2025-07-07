package com.example.assignment5

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

import android.app.DatePickerDialog
import android.text.Editable
import android.text.TextWatcher


class MainActivity : AppCompatActivity() {
    private lateinit var expenseNameInput: EditText
    private lateinit var expenseAmountInput: EditText
    private lateinit var expenseRecyclerView: RecyclerView
    private lateinit var addExpenseButton: FloatingActionButton
    private val expenseList = mutableListOf<Expense>()
    private lateinit var expenseAdapter: ExpenseAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        expenseNameInput = findViewById(R.id.expenseNameInput)
        expenseAmountInput = findViewById(R.id.expenseAmountInput)
        addExpenseButton = findViewById(R.id.addExpenseButton)
        expenseRecyclerView = findViewById(R.id.expenseRecyclerView)


        expenseAdapter = ExpenseAdapter(expenseList){ position ->
            expenseList.removeAt(position)
            expenseAdapter.notifyItemRemoved(position)
        }
        expenseRecyclerView.layoutManager = LinearLayoutManager(this)
        expenseRecyclerView.adapter = expenseAdapter

        addExpenseButton.setOnClickListener(){
            val name = expenseNameInput.text.toString().trim()
            val amountStr = expenseAmountInput.text.toString().trim()

            if(name.isEmpty() || amountStr.isEmpty()){
                Toast.makeText(this,"Please Enter Name and Amount",Toast.LENGTH_SHORT)
                return@setOnClickListener
            }
            val amount = amountStr.toDoubleOrNull()
            if(amount == null){
                Toast.makeText(this,"Invalid",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
        val expense = Expense("coco",1.0)
        expenseList.add(expense)
        expenseAdapter.notifyItemInserted(expenseList.size -1)
        expenseNameInput.text.clear()
        expenseAmountInput.text.clear()

        Toast.makeText(this,"Expense added!", Toast.LENGTH_SHORT).show()


    }

}