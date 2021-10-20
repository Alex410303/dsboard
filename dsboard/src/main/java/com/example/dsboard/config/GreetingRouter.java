package com.example.dsboard.config;

import com.example.dsboard.handlers.GreetingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class GreetingRouter {

    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {
        RequestPredicate req = GET("/hello")
                .and(accept(MediaType.TEXT_PLAIN));
        RequestPredicate reqIndex = GET("/");
//        return RouterFunctions
//                .route(req, greetingHandler::hello)
//                .andRoute(reqIndex, greetingHandler::index);

        return RouterFunctions
                .route(req, greetingHandler::hello)
                .andRoute(
                        RequestPredicates.GET("/"),
                        greetingHandler::index
                );
    }
}
