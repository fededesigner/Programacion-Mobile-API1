
package com.fede.recordatorios

sealed class Categoria {
    data object Personal : Categoria()
    data object Trabajo : Categoria()
    data object Estudio : Categoria()
}

