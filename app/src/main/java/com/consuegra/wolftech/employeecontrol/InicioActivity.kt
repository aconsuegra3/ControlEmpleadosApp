package com.consuegra.wolftech.employeecontrol

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
//import android.support.v7.widget.RecyclerView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_inicio.*

val empleados = ArrayList<Empleado>()

class InicioActivity : AppCompatActivity() {

    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        //val empleados = ArrayList<Empleado>()

        empleados.add(Empleado("Oscar", "Perez", "0318-1998-09213", "oscar@gmail.com", "9843-1254", "Gerente" ,R.drawable.imagenpordefecto))
        empleados.add(Empleado("Juan", "Lopez", "0318-1999-00121", "juan@gmail.com", "3312-1356", "Gerente" ,R.drawable.imagenpordefecto))
        empleados.add(Empleado("Luis", "Rivera", "0318-2005-00092", "lucho@gmail.com", "8752-1123", "Gerente" ,R.drawable.imagenpordefecto))
        empleados.add(Empleado("Ana", "Zelaya", "0318-2000-00111", "ana@gmail.com", "9921-3244", "Gerente" ,R.drawable.imagenpordefecto))

        layoutManager = LinearLayoutManager(this)

        val adapter = AdapterCustom(this, empleados, object: ClickListener {
            override fun onClick(view: View, index: Int) {
                Toast.makeText(applicationContext, empleados[index].nombre, Toast.LENGTH_SHORT).show()
            }
        }, object: LongClickListener{
            override fun LongClickListener(view: View, index: Int) {
                val builder = AlertDialog.Builder(this@InicioActivity)
                builder.setTitle("Eliminar")
                builder.setMessage("¿Está seguro que desea eliminar el empleado ${empleados[index].nombre}")
                builder.setPositiveButton("Si") { _: DialogInterface, _: Int ->
                    empleados.remove(empleados[index])
                    Toast.makeText(this@InicioActivity, "Empleado elminado correctamente", Toast.LENGTH_LONG).show()
                }
                builder.setNegativeButton("No"){_: DialogInterface, _: Int ->

                }
                builder.show()
            }
        })

        recyclerViewEmpleados.setHasFixedSize(true)
        recyclerViewEmpleados.layoutManager = layoutManager
        recyclerViewEmpleados.adapter = adapter

        recyclerViewEmpleados

        // Swipe to refresh
        swipeRefreshLayout.setOnRefreshListener {
            Log.d("REFRESH", "La información se ha refrescado")

            for (i in 1..100000000) {

            }
            swipeRefreshLayout.isRefreshing = false

            adapter.notifyDataSetChanged()

        }


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