package com.consuegra.wolftech.employeecontrol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class IndexActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)
    }
    fun agregarEmpleado(view: View){
        startActivity(Intent(this, NuevoEmpleadoActivity::class.java))
    }
    fun listarEmpleados(view:View){
        startActivity(Intent(this, InicioActivity::class.java))
    }
    fun cerrarSesion(view: View){
        finish()
        startActivity(Intent(this, MainActivity::class.java))
    }
    fun salir(view:View){
        finish()
    }
}
