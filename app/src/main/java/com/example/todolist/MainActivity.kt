package com.example.todolist

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var pk1 = Pokemon()
        pk1.nombre="Charmander"
        pk1.nivel=1
        pk1.estado=false

        var pk2 = Pokemon()
        pk2.nombre="Bulbasaur"
        pk2.nivel=11
        pk2.estado=true

        var pk3 = Pokemon()
        pk3.nombre="Squirtle"
        pk3.nivel=5
        pk3.estado=false



        val listView = findViewById<ListView>(R.id.main_listview)
        //val color = Color.parseColor("#FF0000")
        //listView.setBackgroundColor(color)


        listView.adapter = MyAdapter(this,pk1,pk2,pk3)

    }

    private class MyAdapter(context: Context, pk1: Pokemon,pk2: Pokemon,pk3: Pokemon) : BaseAdapter(){

        private val mContext : Context


        private val nombres = arrayListOf<Pokemon>(pk1,pk2,pk3)

        init {
            mContext = context
        }

        //Responsable de mostrar cada una de las filas
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(mContext)
        val row_main = layoutInflater.inflate(R.layout.row_main,null,false)

        val positionTextView = row_main.findViewById<TextView>(R.id.position_textView)
       //positionTextView.text = "Row Number: $position"
            positionTextView.text="Nivel: ${nombres[position].nivel}"

            val nameTextView = row_main.findViewById<TextView>(R.id.name_textView)
            //nameTextView.text = nombres.get(position).toString()
            nameTextView.text = nombres[position].nombre

            val checkBoxEstatus = row_main.findViewById<CheckBox>(R.id.checkBoxEstatus)
            checkBoxEstatus.isChecked = nombres[position].estado!!

            return row_main
            //val textView = TextView(mContext)
        //    textView.text = "Esta es la fila de mi TextView"
        //    return textView
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
        return nombres.size
        }

    }
}
