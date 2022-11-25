package com.example.app_movil_alquiler_inmuebles.Models

data class Inmuebles(
    var ID : String ? = null,
    var Nombre : String ? = null,
    var Calificacion : String ? = null,
    var Like : Int ? = null,
    var Precio : Int ? = null,
    var Ubicacion : String ? = null,
    var Provincia : String ? = null,
    var CBanios : Int ? = null,
    var CHabitaciones : Int ? = null,
    var Descripcion : String ? = null
) {
    init {
        this.ID = ID
        this.Nombre = Nombre
        this.Calificacion = Calificacion
        this.Like = Like
        this.Precio= Precio
        this.Ubicacion = Ubicacion
        this.Provincia = Provincia
        this.CBanios = CBanios
        this.CHabitaciones = CHabitaciones
        this.Descripcion = Descripcion

    }
}
