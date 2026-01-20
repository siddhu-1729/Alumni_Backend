//package com.example.Alumni_Backend.configuration;
//
//import com.example.Alumni_Backend.services.JWTService;
//import com.example.Alumni_Backend.services.UserService;
//import org.jspecify.annotations.Nullable;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.http.server.ServletServerHttpRequest;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.socket.WebSocketHandler;
//import org.springframework.web.socket.server.HandshakeInterceptor;
//
//import java.util.Map;
//
//public class JWTHandShakeInterceptor implements HandshakeInterceptor {
//
//    JWTService jwtService;
//    UserService userService;
//
//    @Override
//    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
//
//        String token=((ServletServerHttpRequest)request).getServletRequest().getParameter("token");
//        String username= jwtService.extractUsername(token);
//        UserDetails userDetails=userService.userDetailsService().loadUserByUsername(username);
//        attributes.put("username",username);
//        attributes.put("authorities",userDetails.getAuthorities());
//        return true;
//    }
//
//    @Override
//    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, @Nullable Exception exception) {
//
//    }
//}
