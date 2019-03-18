package com.serkaneren.reactive.demo.repository;

import com.serkaneren.reactive.demo.model.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PersonRepository extends ReactiveCrudRepository<Person, String> {


}
