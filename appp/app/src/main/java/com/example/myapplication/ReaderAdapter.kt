package com.example.myapplication


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ReaderAdapter(var readers: List<Reader>) : RecyclerView.Adapter<ReaderAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val firstName: TextView = itemView.findViewById(R.id.tvFirstName)
        val lastName: TextView = itemView.findViewById(R.id.tvLastName)
        val phoneNum: TextView = itemView.findViewById(R.id.tvPhoneNumber)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.reader_item, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val reader = readers[position]
        holder.firstName.text = reader.firstName
        holder.lastName.text = reader.lastName
        holder.phoneNum.text = reader.phoneNum.toString()
    }
    override fun getItemCount(): Int {
        return readers.size
    }
}


