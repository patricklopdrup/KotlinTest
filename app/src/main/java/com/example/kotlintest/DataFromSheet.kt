package com.example.kotlintest

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL

class DataFromSheet {

    var map: MutableMap<String, String>? = null


    @Throws(IOException::class)
    fun dataFromUrl(url: String): String {
        println("Henter data...")

        val br = BufferedReader(InputStreamReader(URL(url).openStream()))
        val sb = java.lang.StringBuilder()
        var row: String? = br.readLine()
        while (row != null) {
            sb.append(row + "\n")
            row = br.readLine()
        }
        return sb.toString()
    }



}