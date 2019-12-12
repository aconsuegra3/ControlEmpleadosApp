package com.consuegra.wolftech.employeecontrol

import android.content.Context
//import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterCustom(var context: Context, var items: ArrayList<Empleado>, var clickListener: ClickListener, var longClickListener: LongClickListener): RecyclerView.Adapter<AdapterCustom.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.template_empleado, parent, false)

        return ViewHolder(view, clickListener, longClickListener)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        // Mapeo
        holder.nombre.text = item.nombre
        holder.apellido.text = item.apellido
        holder.telefono.text = item.telefono
        holder.cargo.text = item.cargo
        holder.foto.setImageResource(item.foto)
    }

    // Mapear las variables de cada item dentro de items con los
    // widgets correspondientes dentro de la vista
    class ViewHolder(var view: View, var clickListener: ClickListener, var longClickListener: LongClickListener): RecyclerView.ViewHolder(view), View.OnClickListener, View.OnLongClickListener {
        override fun onLongClick(v: View?): Boolean {
            longClickListener.LongClickListener(view, adapterPosition)

            return true
        }

        override fun onClick(v: View?) {
            clickListener.onClick(view, adapterPosition)
        }

        var nombre: TextView
        var apellido: TextView
        var telefono: TextView
        var cargo: TextView

        var foto: ImageView

        init {
            this.nombre = view.findViewById(R.id.textViewNombre)
            this.apellido = view.findViewById(R.id.textViewApellido)
            this.telefono = view.findViewById(R.id.textViewTelefono)
            this.cargo = view.findViewById(R.id.textViewCargo)
            this.foto = view.findViewById(R.id.imageViewEmpleado)

            view.setOnClickListener(this)
            view.setOnLongClickListener(this)
        }
    }

}