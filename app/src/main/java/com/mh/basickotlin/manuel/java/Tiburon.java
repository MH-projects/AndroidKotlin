/*
 * Tiburon.java
 * Android Kotlin App
 * Created by Manuel Hidalgo on 02/09/2022, 14:34:00
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.manuel.java;

public class Tiburon extends Animal implements ITiburon {

    public Tiburon() {

    }

    @Override
    public void moverse() {
        System.out.println("Nada");
    }

    public void comer() {
        System.out.println("Come peces");
    }

    public void caza() {
        System.out.println("Con ayuda de sus dientes");
    }

    @Override
    public void olerSandre() {

    }
}
