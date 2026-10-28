package com.fede.recordatorios

sealed class Prioridad {
    data object Alta : Prioridad()
    data object Media : Prioridad()
    data object Baja : Prioridad()
}
