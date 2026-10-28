package com.fede.recordatorios


val recordatoriosSimulados: List<Recordatorio> = listOf(
    Recordatorio(
        titulo = "Comprar leche",
        categoria = Categoria.Personal,
        prioridad = Prioridad.Alta,
        estado = EstadoRecordatorio.Pendiente
    ),
    Recordatorio(
        titulo = "Preparar informe",
        categoria = Categoria.Trabajo,
        prioridad = Prioridad.Media,
        estado = EstadoRecordatorio.Pendiente
    ),
    Recordatorio(
        titulo = "Estudiar Kotlin",
        categoria = Categoria.Estudio,
        prioridad = Prioridad.Baja,
        estado = EstadoRecordatorio.Completado
    )
)


val categoriasDisponibles: Set<Categoria> = setOf(
    Categoria.Personal,
    Categoria.Trabajo,
    Categoria.Estudio,
    Categoria.Personal
)


val etiquetasCategorias: Map<Categoria, String> = mapOf(
    Categoria.Personal to "Personal",
    Categoria.Trabajo to "Trabajo",
    Categoria.Estudio to "Estudio"
)


fun filtrarPorEstado(
    estadoBuscado: EstadoRecordatorio
): List<Recordatorio> {
    return recordatoriosSimulados.filter {
        it.estado == estadoBuscado
    }
}

fun filtrarPorPrioridad(
    prioridadBuscada: Prioridad
): List<Recordatorio> {
    return recordatoriosSimulados.filter {
        it.prioridad == prioridadBuscada
    }
}
fun comprobarFiltros(): Boolean {
    val pendientes =
        filtrarPorEstado(EstadoRecordatorio.Pendiente)

    val prioridadAlta =
        filtrarPorPrioridad(Prioridad.Alta)

    return pendientes.size == 2 &&
            prioridadAlta.size == 1
}
