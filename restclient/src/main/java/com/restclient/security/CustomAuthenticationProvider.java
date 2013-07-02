package com.restclient.security;

import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		return new UsernamePasswordAuthenticationToken(
				authentication.getPrincipal(), authentication.getCredentials(),
				new ArrayList<GrantedAuthority>());
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}
}
