package com.adega.adegagatewayserver.validators;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator{

    public static final List<String> openEndpoints = List.of(
            "/users/create",
            "/users/login");

    public Predicate<ServerHttpRequest> isSecured = request -> openEndpoints.stream()
            .noneMatch(uri -> request.getURI().getPath().contains(uri));

}
