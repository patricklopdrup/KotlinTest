package com.example.kotlintest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {

    public static void main(String[] args) {
        System.out.println("hej");
    }


    public void sendHttp() throws IOException {

        URL url = new URL("hej");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();


    }

}
