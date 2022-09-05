/*
 * MainJava.java
 * Android Kotlin App
 * Created by Manuel Hidalgo on 02/09/2022, 14:29:48
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.manuel.java;

public class MainJava {

    public static void main(String[] argx) {

//        Perro perro = new Perro();
//        Tiburon tiburon = new Tiburon();
//        Aguila aguila = new Aguila();
//
//        perro.comer();
//        tiburon.comer();
//        aguila.comer();

        SQLConnection sqlConnection = new SQLConnection();

        sqlConnection.open();
        sqlConnection.setPort();
        sqlConnection.getInfo();
        sqlConnection.close();
    }
}
