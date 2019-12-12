package com.consuegra.wolftech.employeecontrol


import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.consuegra.wolftech.employeecontrol.InicioActivity
import java.util.*

class NuevoEmpleadoActivity : AppCompatActivity() {

    lateinit var txtNombre:EditText
    lateinit var txtApellido:EditText
    lateinit var txtIdentidad:EditText
    lateinit var txtCorreoEmpleado:EditText
    lateinit var txtTelefono:EditText
    lateinit var cargo:String
    lateinit var rb1: RadioButton
    lateinit var rb2: RadioButton
    lateinit var rb3: RadioButton
    lateinit var imfoto:ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_empleado)

        txtNombre=findViewById(R.id.txtNombre)
        txtApellido=findViewById(R.id.txtApellido)
        txtIdentidad=findViewById(R.id.txtIdentidad)
        txtCorreoEmpleado=findViewById(R.id.txtCorreoEmpleado)
        txtTelefono=findViewById(R.id.txtTelefono)
        rb1=findViewById(R.id.rbGerente)
        rb2=findViewById(R.id.rbSecretario)
        rb3=findViewById(R.id.rbOtro)
        cargo = ""
        imfoto=findViewById(R.id.ibFoto)

        imfoto.setOnClickListener(View.OnClickListener { tomarFoto() })
    }

     private fun tomarFoto() {
         Toast.makeText(this, "Tomar foto", Toast.LENGTH_LONG).show()
    }

    fun guardar(view: View){
        val nombre = txtNombre.text.toString()
        val apellido = txtApellido.text.toString()
        val identidad = txtIdentidad.text.toString()
        val correo = txtCorreoEmpleado.text.toString()
        val telefono = txtTelefono.text.toString()
        if(rb1.isChecked){
            cargo="Gerente"
        }else if(rb2.isChecked){
            cargo="Secretario"
        }else if(rb3.isChecked){
            cargo="Otro"
        }

        empleados.add(Empleado(nombre, apellido, identidad, correo, telefono, cargo ,R.drawable.imagenpordefecto))

        startActivity(Intent(this, InicioActivity::class.java))
        finish()
    }
}
