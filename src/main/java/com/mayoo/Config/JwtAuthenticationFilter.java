package com.mayoo.Config;

import com.mayoo.Service.IJwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    public final IJwtService jwtService;
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull  HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        final String authName = "Authorization";
        final String bearer = "Bearer ";
        final int bearerSize = bearer.length();
        final String authHeader = request.getHeader(authName);
        final String jwt;
        final String  userEmail;
        
        if(authHeader == null || !authHeader.startsWith(bearer)) {
            filterChain.doFilter(request, response);
            return;
        }
        
        jwt = authHeader.substring(bearerSize);
        userEmail = jwtService.extractUsername(jwt);
    }
}
