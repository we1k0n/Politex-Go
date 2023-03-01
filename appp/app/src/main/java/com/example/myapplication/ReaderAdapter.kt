package com.example.myapplication


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ReaderAdapter(private val context: Context, var readers: List<Reader>) : RecyclerView.Adapter<ReaderAdapter.ViewHolder>() {

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

        holder.itemView.setOnClickListener{
            onReaderClick(reader, position)
        }
    }
    override fun getItemCount(): Int {
        return readers.size
    }

    fun onReaderClick(readers: Reader, position: Int){
        val intent = Intent(context, inforeader::class.java).apply{
            putExtra(EXTRA_FIRST_NAME,readers.firstName)
            putExtra(EXTRA_LAST_NAME, readers.lastName)
            putExtra(EXTRA_ADDRESS, readers.address)
            putExtra(EXTRA_PHONE_NUM, readers.phoneNum)

        }
        context.startActivity(intent)
    }
    companion object{
        const val EXTRA_FIRST_NAME = "extra_first_name"
        const val EXTRA_LAST_NAME = "extra_last_name"
        const val EXTRA_ADDRESS = "extra_address"
        const val EXTRA_PHONE_NUM = "extra_phone_num"
    }
}


