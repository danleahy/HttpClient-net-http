package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    private HttpClient httpClient;

    @BeforeEach
    void setUp() {
        httpClient = HttpClient.newBuilder().build();
    }

    @Test
    void clientTest() throws URISyntaxException, IOException, InterruptedException {
        //Arrange
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .version(HttpClient.Version.HTTP_2)
                .uri(new URI("https://postman-echo.com/get")).build();

        //Act
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        //Assert
        assertEquals(200, response.statusCode());
    }
}
