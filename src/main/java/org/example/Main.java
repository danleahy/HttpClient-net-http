package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {


        System.out.println("Hello world!");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .version(HttpClient.Version.HTTP_2)
                .uri(new URI("https://postman-echo.com/get")).build();


        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response);
        System.out.println(response.statusCode());
    }
}
