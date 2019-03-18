package com.serkaneren.reactive.demo.client;

import com.serkaneren.reactive.demo.model.Person;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class PersonWebClient {

    private WebClient webClient = WebClient.create("http://localhost:8080");

    private Mono<ClientResponse> result = webClient.get()
            .uri("/persons")
            .accept(MediaType.APPLICATION_JSON_UTF8)
            .exchange();

    public String getResult() {
        return ">> result = " + result.flatMap(res -> res.bodyToMono(Person.class)).block();
    }
}
