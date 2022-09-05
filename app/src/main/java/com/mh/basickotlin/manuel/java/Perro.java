/*
 * Perro.java
 * Android Kotlin App
 * Created by Manuel Hidalgo on 02/09/2022, 14:31:07
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.manuel.java;

public class Perro extends Animal implements IPerro {

    public Perro() {
    }

    @Override
    public void moverse() {
        System.out.println("Caminar y correr");
    }

    @Override
    public void respirar() {
        super.respirar();
    }

    @Override
    public void ladrar() {
        System.out.println("Gua gua");
    }
}
