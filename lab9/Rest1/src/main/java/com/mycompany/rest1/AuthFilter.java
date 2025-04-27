/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rest1;

/**
 *
 * @author michal
 */

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authHeader = requestContext.getHeaderString("Authorization");

        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            abortWithUnauthorized(requestContext);
            return;
        }

        String encodedCredentials = authHeader.substring("Basic ".length());
        String decodedCredentials = new String(Base64.getDecoder().decode(encodedCredentials), StandardCharsets.UTF_8);

        String[] parts = decodedCredentials.split(":", 2);
        if (parts.length != 2) {
            abortWithUnauthorized(requestContext);
            return;
        }

        String username = parts[0];
        String password = parts[1];

        if (!("admin".equals(username) && "admin".equals(password))) {
            abortWithUnauthorized(requestContext);
        }
    }

    private void abortWithUnauthorized(ContainerRequestContext requestContext) {
        requestContext.abortWith(
            Response.status(Response.Status.UNAUTHORIZED)
                    .header("WWW-Authenticate", "Basic realm=\"Access to the API\"")
                    .entity("Access denied for this resource")
                    .build()
        );
    }
}

