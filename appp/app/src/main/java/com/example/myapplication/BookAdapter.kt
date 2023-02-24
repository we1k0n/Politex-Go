package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.coroutines.coroutineContext

class BookAdapter(private val context: Context, var books: List<Book>) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.tvName)
        val authorTextView: TextView = itemView.findViewById(R.id.tvAuthor)
        val yearTextView: TextView = itemView.findViewById(R.id.tvYear)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = books[position]
        holder.nameTextView.text = book.name
        holder.authorTextView.text = book.author
        holder.yearTextView.text = book.year

        holder.itemView.setOnClickListener{
            onBookClick(book, position)
        }
    }

    override fun getItemCount(): Int {
        return books.size
    }
    fun onBookClick(book: Book, position: Int){
        val intent = Intent(context, Infobook::class.java).apply{
            putExtra(EXTRA_NAME, book.name)
            putExtra(EXTRA_AUTHOR, book.author)
            putExtra(EXTRA_YEAR, book.year)
            putExtra(EXTRA_ROW, book.row)
            putExtra(EXTRA_RACK, book.racks)
            putExtra(EXTRA_SHELF, book.shelf)
        }
        context.startActivity(intent)
    }
    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_AUTHOR = "extra_author"
        const val EXTRA_YEAR = "extra_year"
        const val EXTRA_ROW = "extra_row"
        const val EXTRA_RACK = "extra_rack"
        const val EXTRA_SHELF = "extra_shelf"
    }
}


