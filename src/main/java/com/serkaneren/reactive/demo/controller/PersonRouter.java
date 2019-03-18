package com.serkaneren.reactive.demo.controller;

import com.serkaneren.reactive.demo.model.Person;
import com.serkaneren.reactive.demo.repository.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.BodyExtractors.toMono;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

public class PersonRouter {

    @Bean
    RouterFunction<?> routes(PersonRepository personRepository) {
        return nest(path("/persons"),
                route(GET("/{id}"),
                        request -> ok().body(personRepository.findById(request.pathVariable("id")), Person.class))
                .andRoute(GET(""),
                        req -> ok().body(
                                personRepository.findAll(), Person.class))
                .andRoute(POST(""),
                        req -> req.body(toMono(Person.class))
                                .doOnNext(personRepository::save)
                                .then(ok().build()))
        );
    }
}
