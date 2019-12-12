package com.consuegra.wolftech.employeecontrol

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    lateinit var btnIngresar: Button
    lateinit var txtCorreo: EditText
    lateinit var txtContrasena: EditText
    lateinit var progressBar: ProgressBar
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIngresar = findViewById(R.id.btnIngresar)
        txtCorreo = findViewById(R.id.txtTelefono)
        txtContrasena = findViewById(R.id.txtContrasena)
        progressBar = findViewById(R.id.progressBarLogin)
        auth = FirebaseAuth.getInstance()

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
    fun registrarse(view:View){
        startActivity(Intent(this, RegistroActivity::class.java))
    }
    fun login(view: View){
        loginUser()
    }
    private fun loginUser(){
        val usuario:String = txtCorreo.text.toString()
        val contrasena:String = txtContrasena.text.toString()

        if(!TextUtils.isEmpty(usuario) && !TextUtils.isEmpty(contrasena)){
            progressBar.visibility = View.VISIBLE

            auth.signInWithEmailAndPassword(usuario, contrasena)
                    .addOnCompleteListener(this){
                        task ->

                        if(task.isSuccessful){
                            action()
                        }else{
                            Toast.makeText(this,"Error en la autenticación", Toast.LENGTH_LONG).show()
                        }
                    }
        }
    }
    private fun action(){
        startActivity(Intent(this, InicioActivity::class.java))
        finish()
    }
}
