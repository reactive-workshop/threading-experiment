package com.reactivedemo.events;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EventService {

    public Flux<Event> getAllEvents() {

        return WebClient.create("https://httpbin.org/delay/30").get().retrieve()
                .bodyToMono(ResponseStub.class)
                .thenMany(Flux.just(new Event("1", "Geeknight-Bangalore", "Blockchain technologies")));
    }

    public Mono<Event> upcomingEvent() {
        return Mono.just(new Event("1", "Reactive-workshop-Bangalore", "Reactive programming concepts"));
    }
}

class ResponseStub { }