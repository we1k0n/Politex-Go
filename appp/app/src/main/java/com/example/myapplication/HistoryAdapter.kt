package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.RecyclerView

class HistoryAdapter(private val context: Context,var historys: List<History>, var db: DB): RecyclerView.Adapter<HistoryAdapter.ViewHolder>(),
    LifecycleOwner {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val historyBookId : TextView = itemView.findViewById(R.id.hsBookId)
        val historyNameBook : TextView = itemView.findViewById(R.id.hsNameBook)
        val historyAuthorBook : TextView = itemView.findViewById(R.id.hsAuthorBook)
        val historyReaderId : TextView = itemView.findViewById(R.id.hsReaderId)
        val historyReaderFirst : TextView = itemView.findViewById(R.id.hsReaderFirst)
        val historyReaderLast : TextView = itemView.findViewById(R.id.hsReaderLast)
        val historyLogin : TextView = itemView.findViewById(R.id.hsLogin)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.history_item, parent, false)
        return HistoryAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return historys.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val history = historys[position]
        db.getDao().historyBook(history.bookId).asLiveData().observe(this){
            holder.historyBookId.text = it[position].id.toString()
            holder.historyNameBook.text = it[position].name
            holder.historyAuthorBook.text = it[position].author
        }



//        holder.historyReaderId.text = reader.id.toString()
//        holder.historyReaderFirst.text = reader.firstName
//        holder.historyReaderLast.text = reader.lastName
//        holder.historyLogin.text = librarian.login
    }

//    override fun getLifecycle() {
//
//    }


}