package com.bms.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import com.bms.exception.JwtException;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException{
	  	System.out.println("in filter: entered");
	  	HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        final String authHeader = httpServletRequest.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
            return;
        }
        
        try {
        	System.out.println("yes header");
        	
            final String jwt = authHeader.substring(7);
            Jws<Claims> jwts = Jwts.parserBuilder()
            	      .setSigningKey("asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4")
            	      .build()
            	      .parseClaimsJws(jwt);
            System.out.println(jwts);
            filterChain.doFilter(request, response);
        } catch (Exception exception) {
        	throw new JwtException(exception.getMessage());
        }		
	}
}
