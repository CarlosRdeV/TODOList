package com.example.todolist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        var txtname : EditText
        var txtdescripcion : EditText

        txtname = findViewById(R.id.nametxt)
        txtdescripcion = findViewById(R.id.descripciontxt)

        button_agregar.setOnClickListener{
            var actividad = Actividad()
            actividad.nombre = txtname.text.toString()
            actividad.descripcion = txtdescripcion.text.toString()
            actividad.estado=false

            agregarActividad(Constantes.actividades,actividad)

            //Toast.makeText(this,actividad.toString(),Toast.LENGTH_LONG).show()
            Toast.makeText(this,"Se ha añadido la Actividad",Toast.LENGTH_LONG).show()

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun agregarActividad(actividades: ArrayList<Actividad>?, actividad: Actividad)
    {
        actividades?.add(actividad)
    }
}
