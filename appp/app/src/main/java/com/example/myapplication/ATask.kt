package com.example.myapplication

import android.os.AsyncTask

class ATask(val db: DB, val type: Int, val callback: (Boolean) -> Unit) :
    AsyncTask<Any, Void, Boolean>() {
    override fun doInBackground(vararg p: Any): Boolean {
        try {
            when (type) {
                1 -> db.getDao().insertLibrarian(p[0] as Librarian)
                2 -> db.getDao().insertBook(p[0] as Book)
                3 -> db.getDao().insertReader(p[0] as Reader)
            }

            return true
        } catch (e: Exception) {
            e.printStackTrace()
            return false

        }
    }

    override fun onPostExecute(result: Boolean) {
        super.onPostExecute(result)
        callback(result)
    }
}