/*
 * IConnection.java
 * Android Kotlin App
 * Created by Manuel Hidalgo on 02/09/2022, 14:43:09
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.manuel.java;

public interface IConnection {

    void open();

    void setPort();

    void close();

    void getInfo();
}
