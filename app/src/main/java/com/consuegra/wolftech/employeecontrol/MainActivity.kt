package com.consuegra.wolftech.employeecontrol

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonIngresar: Button = findViewById(R.id.btnIngresar)
        val textCorreo: EditText = findViewById(R.id.txtCorreo)
        val txtContrasena: EditText = findViewById(R.id.txtContrasena)

        botonIngresar.setOnClickListener {
            if(textCorreo.text.toString() == "admin" && txtContrasena.text.toString() == "admin"){
                val intent = Intent(this , InicioActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show()
                textCorreo.requestFocus()
            }
        }
    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle("Salir")
            builder.setMessage("¿Está seguro que desea salir?")
            builder.setPositiveButton("Si") { _: DialogInterface, _: Int ->
                finish()
            }
            builder.setNegativeButton("No"){_: DialogInterface, _: Int ->

            }
            builder.show()
        }
        return super.onKeyDown(keyCode, event)
    }
}
