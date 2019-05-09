package com.example.todolist

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var actividad1 = Actividad()
        actividad1.nombre="Leer"
        actividad1.descripcion="Leer es el hábito que te impulsará. Pues te da acceso a las ideas, errores y experiencias de los éxitosos"
        actividad1.estado=false

        var actividad2 = Actividad()
        actividad2.nombre="Ejercicio"
        actividad2.descripcion="El ejercicio fisico tiene grandes beneficios para tu vida y te acerca al éxito. Salud = Éxito"
        actividad2.estado=false

        var actividad3 = Actividad()
        actividad3.nombre="Meditación"
        actividad3.descripcion="La meditación tiene grandes efectos sobre tu productividad. Aprende a encontrarte a tu mismo y olvidarte de todo a tu alrededor"
        actividad3.estado=false

        var actividad4 = Actividad()
        actividad4.nombre="Emprendimiento"
        actividad4.descripcion="Utiliza esta hora para hacer algo productivo por tu idea, no es aprender, es acción pura"
        actividad4.estado=false

        var actividad5 = Actividad()
        actividad5.nombre="Disfrutar"
        actividad5.descripcion="También necesitas para tiempo de calidad con tu familia y amigos. Olvidate del trabajo, esto renueva energias"
        actividad5.estado=false


        var actividades = arrayListOf<Actividad>(actividad1,actividad2,actividad3,actividad4,actividad5)

        val listView = findViewById<ListView>(R.id.main_listview)
        //val color = Color.parseColor("#FF0000")
        //listView.setBackgroundColor(color)
        listView.adapter = MyAdapter(this,actividades)

        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener {
              val intent = Intent(this,AddActivity::class.java)
                startActivity(intent)
                //view ->
            //Toast.makeText(this,"Suma",Toast.LENGTH_LONG).show()
        }

    }

    private class MyAdapter(context: Context, actividades: ArrayList<Actividad> ) : BaseAdapter(){

        private val mContext : Context
        private val actividades = actividades

        init {
            mContext = context
        }

        //Responsable de mostrar cada una de las filas
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(mContext)
        val row_main = layoutInflater.inflate(R.layout.row_main,null,false)

        val positionTextView = row_main.findViewById<TextView>(R.id.position_textView)
       //positionTextView.text = "Row Number: $position"
            positionTextView.text="Descripción: ${actividades?.get(position)?.descripcion}"

            val nameTextView = row_main.findViewById<TextView>(R.id.name_textView)
            //nameTextView.text = nombres.get(position).toString()
            nameTextView.text = actividades?.get(position)?.nombre

            val checkBoxEstatus = row_main.findViewById<CheckBox>(R.id.checkBoxEstatus)
            checkBoxEstatus.isChecked = actividades?.get(position)?.estado!!

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
            if (actividades != null) {
                return actividades!!.size
            }
            return 0
        }

    }


}
