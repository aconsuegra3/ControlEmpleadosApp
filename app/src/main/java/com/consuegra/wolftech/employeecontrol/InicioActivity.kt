package com.consuegra.wolftech.employeecontrol

import android.content.DialogInterface
import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class InicioActivity : AppCompatActivity() {

    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)


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