

package com.fede.recordatorios

data class Recordatorio(
    val titulo: String,
    val categoria: Categoria,
    val prioridad: Prioridad,
    val estado: EstadoRecordatorio,
    val ubicacion: String? = null
)

fun validarTitulo(titulo: String): Boolean {
    return titulo.isNotBlank()
}
