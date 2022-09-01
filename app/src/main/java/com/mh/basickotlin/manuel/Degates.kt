/*
 * Degates.kt
 * Android Kotlin App
 * Created by Manuel Hidalgo on 31/08/2022, 13:58:54
 * Copyright (c) 2022 Develop-MX. All rights reserved.
 */

package com.mh.basickotlin.manuel

interface Player {
    fun play()
}

interface Downloader {
    fun download()
}

class MediaFile(
    private val player: Player,
    private val downloader: Downloader
) : Downloader by downloader, Player by player

class FileDownloader(private val file: String) : Downloader {

    override fun download() {
        println("Downloading $file")
    }
}

class FilePlayer(private val file: String) : Player {

    override fun play() {
        println("Playing $file")
    }
}

fun main() {
    val file = "video.mp4"
    val mediaFile = MediaFile(FilePlayer(file), FileDownloader(file))

    mediaFile.download()
    mediaFile.play()
}

class Degates
