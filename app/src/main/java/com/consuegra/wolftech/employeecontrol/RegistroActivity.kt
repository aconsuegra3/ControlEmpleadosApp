package com.consuegra.wolftech.employeecontrol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegistroActivity : AppCompatActivity() {

    private lateinit var txtNombre:EditText
    private lateinit var txtApellido:EditText
    private lateinit var txtCorreo:EditText
    private lateinit var txtContrasena:EditText
    private lateinit var progressBar:ProgressBar
    private lateinit var dbReference:DatabaseReference
    private lateinit var database:FirebaseDatabase
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        txtNombre=findViewById(R.id.txtNombre)
        txtApellido=findViewById(R.id.txtApellido)
        txtCorreo=findViewById(R.id.txtTelefono)
        txtContrasena=findViewById(R.id.txtContrasena)

        progressBar = findViewById(R.id.progressBar)

        database = FirebaseDatabase.getInstance()
        auth = FirebaseAuth.getInstance()

        dbReference = database.reference.child("Usuario")
    }

    fun registro(view: View){
        crearCuentaNueva()
    }

    private fun crearCuentaNueva(){
        val nombre = txtNombre.text.toString()
        val apellido = txtApellido.text.toString()
        val correo = txtCorreo.text.toString()
        val contrasena = txtContrasena.text.toString()

        if(!TextUtils.isEmpty(nombre) && !TextUtils.isEmpty(apellido) && !TextUtils.isEmpty(correo) && !TextUtils.isEmpty(contrasena)){
            progressBar.visibility= View.VISIBLE

            auth.createUserWithEmailAndPassword(correo, contrasena)
                    .addOnCompleteListener(this){
                        task ->

                        if (task.isComplete){
                            val user: FirebaseUser?=auth.currentUser
                            verifyEmail(user)

                            val userDB = dbReference.child(user?.uid!!)

                            userDB.child("Nombre").setValue(nombre)
                            userDB.child("Apellido").setValue(apellido)
                            action()
                        }
                    }
        }
    }

    private fun action() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun verifyEmail(user:FirebaseUser?){
        user?.sendEmailVerification()
            ?.addOnCompleteListener(this){
                task ->

                if(task.isComplete){
                    Toast.makeText(this, "Email Enviado", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this, "Error en Email", Toast.LENGTH_LONG).show()
                }
            }
    }
}
