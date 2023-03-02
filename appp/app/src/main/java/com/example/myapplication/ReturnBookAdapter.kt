package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReturnBookAdapter(private val context: Context, var books: List<Book>,private val listener: OnItemClickListener) : RecyclerView.Adapter<ReturnBookAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.tvName)
        val authorTextView: TextView = itemView.findViewById(R.id.tvAuthor)
        val yearTextView: TextView = itemView.findViewById(R.id.tvYear)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = books[position]
        holder.nameTextView.text = book.name
        holder.authorTextView.text = book.author
        holder.yearTextView.text = book.year
        holder.itemView.setOnClickListener {
            listener.OnItemClickBook(book)
        }

    }

    fun OnItemClickBook(book: Book){

    }
}



