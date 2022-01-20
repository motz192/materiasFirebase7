package com.example.firebasematerias

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.AutoText
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.firebasematerias.databinding.ActivityMainBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.database.DatabaseReference

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseError

import com.google.firebase.database.DataSnapshot

import com.google.firebase.database.ValueEventListener







class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = Firebase.database.reference







        binding.btEnviar.setOnClickListener {
            var nombreDelAlumno: String? = binding.tfAlumno.text.toString()
            var materia1: String? = binding.tfMateria1.text.toString()
            var materia2: String? = binding.tfMateria2.text.toString()
            var materia3: String? = binding.tfMateria3.text.toString()
            var docenteMateria1: String? = null
            var docenteMateria2: String? = null
            var docenteMateria3: String? = null
            var aula1: Int = 16
            var aula2: Int = 16
            var aula3: Int = 12
            val dataRef = database.child("$nombreDelAlumno")
            when(materia1){
                "Fundamentos de programacion" -> docenteMateria1 ="MSC. Jose Antonio Hiram Vasquez Lopez"
                "Matematicas discretas" -> docenteMateria1 = "Ing. Guadalupe Guendulay Escalante"
                "Taller de administracion" -> docenteMateria1 = "Cp. Refugio Diaz Arcos"
                "Taler de etica" -> docenteMateria1 = "Ing. Elsa Saldaña"
                "Calculo diferencial" -> docenteMateria1 = "Lic. Eliud Polo"
                "Fundamentos de investigacion" -> docenteMateria1 = "Lic. Xochilt García"
                else -> docenteMateria1 = "No encontrada"
            }
            when(materia2){
                "Fundamentos de programacion" -> docenteMateria2 ="Ing. Aracely Vasquez Castro"
                "Matematicas discretas" -> docenteMateria2 = "Ing. Guadalupe Guendulay Escalante"
                "Taller de administracion" -> docenteMateria2 = "Cp. Refugio Diaz Arcos"
                "Taler de etica" -> docenteMateria2 = "Ing. Elsa Saldaña"
                "Calculo diferencial" ->docenteMateria2 = "Lic. Jose Salas"
                "Fundamentos de investigacion" ->docenteMateria2 = "Lic. Xochilt García"
                else -> docenteMateria2 = "No encontrada"
            }
            when(materia3){
                "Fundamentos de programacion" -> docenteMateria3 ="MSC. Jose Antonio Hiram Vasquez Lopez"
                "Matematicas discretas" -> docenteMateria3 = "Ing. Guadalupe Guendulay Escalante"
                "Taller de administracion" -> docenteMateria3 = "Cp. Refugio Diaz Arcos"
                "Taler de etica" -> docenteMateria3 = "Ing. Elsa Saldaña"
                "Calculo diferencial" ->docenteMateria3 = "Lic. Eduardo Enrique"
                "Fundamentos de investigacion" ->docenteMateria3 = "Lic. Octavio Sesma"
                else -> docenteMateria3 = "No encontrada"
            }
            dataRef.child("materia 1").child("Nombre de la materia").setValue("$materia1")
            dataRef.child("materia 2").child("Nombre de la materia").setValue("$materia2")
            dataRef.child("materia 3").child("Nombre de la materia").setValue("$materia3")
            dataRef.child("materia 1").child("docente de Materia").setValue(docenteMateria1)
            dataRef.child("materia 2").child("docente de Materia").setValue(docenteMateria2)
            dataRef.child("materia 3").child("docente de Materia").setValue(docenteMateria3)
            dataRef.child("materia 1").child("Aula").setValue("$aula1")
            dataRef.child("materia 2").child("Aula").setValue("$aula2")
            dataRef.child("materia 3").child("Aula").setValue("$aula3")

        }
        binding.btBorrar.setOnClickListener {
            var nombreDelAlumno: String? = binding.tfAlumno.text.toString()
            val dataRef = database.child("$nombreDelAlumno")
            dataRef.removeValue()

        }






    }
}















