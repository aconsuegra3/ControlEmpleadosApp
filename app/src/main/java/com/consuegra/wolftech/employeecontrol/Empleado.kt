package com.consuegra.wolftech.employeecontrol

class Empleado (nombre:String, apellido:String, identidad:String, correo:String, telefono:String, cargo:String, foto:Int) {
    var nombre: String = ""
    var apellido: String = ""
    var identidad: String = ""
    var correo: String = ""
    var telefono: String = ""
    var cargo: String = ""
    var foto: Int = 0

    init{
        this.nombre = nombre
        this.apellido = apellido
        this.identidad = identidad
        this.correo = correo
        this.telefono = telefono
        this.cargo = cargo
        this.foto = foto
    }
}