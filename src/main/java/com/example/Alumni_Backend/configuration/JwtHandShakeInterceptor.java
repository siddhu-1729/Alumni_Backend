package com.example.Alumni_Backend.configuration;

import com.example.Alumni_Backend.services.JWTService;
import org.jspecify.annotations.Nullable;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

public class JwtHandShakeInterceptor implements HandshakeInterceptor {

    private JWTService jwtService;

    public JwtHandShakeInterceptor(JWTService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        String token = request.getHeaders().getFirst("Authorization");
         if(token!=null && token.startsWith("Bearer ")){
             token=token.substring(7);

             String email = jwtService.extractUsername(token);
             attributes.put("user",email);
             return true;
         }
        return false;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, @Nullable Exception exception) {

    }
}
