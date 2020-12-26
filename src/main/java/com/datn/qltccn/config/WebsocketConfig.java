package com.datn.qltccn.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration //  config spring boot
@EnableWebSocketMessageBroker // enable socket message and STOMP messaging.
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {
    private final Logger log = LoggerFactory.getLogger(WebsocketConfig.class);

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        log.info("------websocket running!----");
        // endPoint to config StompJS in client app
        // http://localhost:4200
        registry.addEndpoint("/greeting").setAllowedOrigins("http://localhost:4200").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        log.info("------------ websocket config!--------------");
        registry.enableSimpleBroker( "/queue");
        registry.setApplicationDestinationPrefixes("/app");
    }
}
