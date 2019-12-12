package com.consuegra.wolftech.employeecontrol

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.appcompat.app.AlertDialog

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

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Salir")
            builder.setMessage("¿Está seguro que desea salir?")
            builder.setPositiveButton("Si") { _: DialogInterface, _: Int ->
                finish()
            }
            builder.setNegativeButton("No") { _: DialogInterface, _: Int ->

            }
            builder.show()
        }
        return super.onKeyDown(keyCode, event)
    }
}
