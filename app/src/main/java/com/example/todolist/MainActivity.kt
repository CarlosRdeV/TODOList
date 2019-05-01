package com.example.todolist

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_listview)
        //val color = Color.parseColor("#FF0000")
        //listView.setBackgroundColor(color)

        listView.adapter = MyAdapter(this)

    }

    private class MyAdapter(context: Context) : BaseAdapter(){

        private val mContext : Context

        init {
            mContext = context
        }

        //Responsable de mostrar cada una de las filas
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val textView = TextView(mContext)
            textView.text = "Esta es la fila de mi TextView"
            return textView
        }

        //Ignotar por ahora
        override fun getItem(position: Int): Any {
        return  "TEST STRING"
        }

        //Ignorar por ahora
        override fun getItemId(position: Int): Long {
        return  position.toLong()
        }

        //Responsable de cuantas filas voy a tener en mi lista
        override fun getCount(): Int {
        return 5
        }

    }
}
