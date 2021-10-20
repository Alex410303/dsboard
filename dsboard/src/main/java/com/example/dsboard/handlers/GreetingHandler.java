package com.example.dsboard.handlers;

import org.springframework.http.MediaType;
import org.springframework.http.ReactiveHttpOutputMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class GreetingHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {

        BodyInserter<Object, ReactiveHttpOutputMessage> body = BodyInserters.fromValue("Hello, world!");
        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(body);
    }

    //    public Mono<ServerResponse> index(ServerRequest request) {
//
//        BodyInserter<Object, ReactiveHttpOutputMessage> body = BodyInserters.fromValue("Hello, index!");
//        return ServerResponse
//                .ok()
//                .render("index", Map.of("name", request.queryParam("name").orElse("null")));
//    }
    public Mono<ServerResponse> index(ServerRequest serverRequest) {
        String user = serverRequest.queryParam("user")
                .orElse("123123123");

        return ServerResponse
                .ok()
                .render("index", Map.of("user", user));
    }
}