package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.BookItemBinding

class BookAdapter: RecyclerView.Adapter<BookAdapter.BookHolder>() {
    val bookList = ArrayList<Book>()
    class BookHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = BookItemBinding.bind(item)
        fun bind(book: Book) = with(binding){
            im.setImageResource(book.imageId)
            tvTitle.text = book.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        return BookHolder(view)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        holder.bind(bookList[position])
    }

    fun addBook(book: Book){
        bookList.add(book)
        notifyDataSetChanged()
    }
}