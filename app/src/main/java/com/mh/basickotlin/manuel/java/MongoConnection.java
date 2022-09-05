/*
 * SQLConnection.java
 * Android Kotlin App
 * Created by Manuel Hidalgo on 02/09/2022, 14:43:51
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.manuel.java;

public class MongoConnection implements IConnection {

    @Override
    public void open() {
        System.out.println("MONGO OPEN");
    }

    @Override
    public void setPort() {
        System.out.println("PORT: 8888");
    }

    @Override
    public void close() {
        System.out.println("MONGO CLOSE");
    }

    @Override
    public void getInfo() {
        System.out.println("GET INFO MONGO");
    }
}
