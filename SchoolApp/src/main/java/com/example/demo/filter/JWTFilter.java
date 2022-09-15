package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String authHeader = httpRequest.getHeader("authorization");

		if (authHeader == null || !authHeader.startsWith("Bearer")) {
			throw new ServletException("Missing or invalid authentication header");
		}

		String jwtToken = authHeader.substring(7);

//		String[] pieces = jwtToken.split("\\.");
//		String b64payload = pieces[1];
//		Base64.Decoder dec = Base64.getDecoder();
//		byte[] jsonString = dec.decode(b64payload);
//		String s = new String(jsonString);
//		System.out.println(s);
//		String[] name = s.split("\\,");
//		String[] s2 = name[0].split(":");
//		// String S4=s2[1];
//		String userName2 = s2[1].replaceAll("\"", "");

		Claims claims = Jwts.parser().setSigningKey("my secret sign").parseClaimsJws(jwtToken).getBody();
		httpRequest.setAttribute("username", claims);
		chain.doFilter(request, response);

	}

}