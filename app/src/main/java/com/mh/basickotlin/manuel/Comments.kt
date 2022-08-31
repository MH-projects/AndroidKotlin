/*
 * Comments.kt
 * Android Kotlin App
 * Created by Manuel Hidalgo on 31/08/2022, 10:36:28
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.manuel

class Comments {

    // Comentario de una sola linea
    val points: String = "" // Puntos de programación de 0-100

    /* Comentario de bloque
    de multiples lineas
    */

    /**
     * Función que recibe dos paratros y regresa
     * la suma de los 2 digitos.
     *
     * @param x: Int
     * @param y: Int
     * @return result: Int
     */
    fun suma(x: Int, y: Int) = x + y
}
