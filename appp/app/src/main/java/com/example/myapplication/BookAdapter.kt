package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.BookItemBinding

class BookAdapter: RecyclerView.Adapter<BookAdapter.BookViewHolder>() {
    private var list = mutableListOf<Book>()
    class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_item,parent , false)
        return BookViewHolder(view)
    }

    override fun getItemCount() = list.size

    fun setData(data: List<Book>) {
        list.apply {
            clear()
            addAll(data)
        }
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = list[position]
        holder.tvName.text = book.name
    }
}

//    fun removeItem(pos: Int, calManager: CalManager){
//        // удаляем элемент из списка
//
//        calManager.deleteMeeting(listItems[pos].uri) // удаляем встречу из календаря
//        listItems.removeAt(pos) // удаляем элемент из списка с позиции pos
//        notifyItemRangeChanged(0,listItems.size) // указываем адаптеру новый диапазон элементов
//        notifyItemRemoved(pos) // указываем адаптеру, что один элемент удалился
//    }
