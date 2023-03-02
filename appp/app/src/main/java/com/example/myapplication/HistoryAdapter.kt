package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.RecyclerView

class HistoryAdapter(private val context: Context,var historys: List<History>, var db: DB,val q:AppCompatActivity): RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val historyBookId: TextView = itemView.findViewById(R.id.hsBookId)
        val historyNameBook: TextView = itemView.findViewById(R.id.hsNameBook)
        val historyAuthorBook: TextView = itemView.findViewById(R.id.hsAuthorBook)
        val historyReaderId: TextView = itemView.findViewById(R.id.hsReaderId)
        val historyReaderFirst: TextView = itemView.findViewById(R.id.hsReaderFirst)
        val historyReaderLast: TextView = itemView.findViewById(R.id.hsReaderLast)
        val historyLogin: TextView = itemView.findViewById(R.id.hsLogin)
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
        db.getDao().historyBook(history.bookId).asLiveData().observe(q) {
            it.forEach{
                holder.historyBookId.text = it.id.toString()
                holder.historyNameBook.text = it.name
                holder.historyAuthorBook.text = it.author
            }
        }
        db.getDao().historyReader(history.readerId).asLiveData().observe(q) {
            it.forEach{
                holder.historyReaderId.text = it.id.toString()
                holder.historyReaderFirst.text = it.firstName
                holder.historyReaderLast.text = it.lastName
            }
        }
        db.getDao().historyLibrian(history.librarianId).asLiveData().observe(q) {
            it.forEach{
                holder.historyLogin.text = it.login
            }
        }
    }
}

