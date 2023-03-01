package com.example.myapplication


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class ReaderBookAdapter(private val context: Context, var readers: List<Reader>, private val listener: OnItemClickListener) : RecyclerView.Adapter<ReaderAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReaderAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.reader_item, parent, false)
        return ReaderAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return readers.size
    }

    override fun onBindViewHolder(holder: ReaderAdapter.ViewHolder, position: Int) {
        val reader = readers[position]
        holder.firstName.text=reader.firstName
        holder.lastName.text=reader.lastName
        holder.phoneNum.text=reader.phoneNum.toString()
        holder.itemView.setOnClickListener{
            listener.OnItemClick(reader)
        }
    }
}


