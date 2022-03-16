package com.perficient.movie_reviewmax.custom.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CustomAccessDeniedHandler implements AccessDeniedHandler{
	
	Logger logger = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);
	
	public CustomAccessDeniedHandler() {
	}

	@Override
	@ExceptionHandler
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException, InvalidCsrfTokenException {
		
		accessDeniedException.printStackTrace();
//		System.out.println(request.getHeader("Cookie"));
		logger.error("Access denied to user");
		
		//throw new AccessDeniedException("403 returned");
		// TODO Auto-generated method stub+
		response.sendError(403);
	}
	
	
}
