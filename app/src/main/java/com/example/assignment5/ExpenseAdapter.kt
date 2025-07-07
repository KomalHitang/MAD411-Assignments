package com.example.assignment5

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import android.widget.AbsListView.RecyclerListener
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView


class ExpenseAdapter (
    private val expenses: MutableList<Expense>,
    private val onDeleteClick: (Int)-> Unit
): RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>(){
    inner class ExpenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameText: TextView= itemView.findViewById(R.id.expenseNameText)
        val amountText: TextView= itemView.findViewById(R.id.amountText)
        val deleteButton : Button = itemView.findViewById(R.id.deleteButton)
    }
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder{
        val view = LayoutInflater.from (parent.context).inflate(R.layout.expense_item, parent,false)
            return ExpenseViewHolder(view)
    }
    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int){
        val expense = expenses[position]
        holder.nameText.text = expense.name
        holder.amountText.text="$${expense.amount}"
        holder.deleteButton.setOnClickListener(onDeleteClick(position))
    }
    override fun getItemCount(): Int = expenses.size
}

private fun Button.setOnClickListener(onDeleteClick: Unit) {

}


