package com.AndgelDuport.Assignment2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
public class Assignment2Application {


	@GetMapping("/username")
	public Map<String, Object> username(@AuthenticationPrincipal OAuth2User connected) {
		Map<String, Object> nameAttribute = Collections.singletonMap("name", connected.getAttribute("name"));
		if (nameAttribute.get("name") == null) {
			nameAttribute = Collections.singletonMap("name", connected.getAttribute("login"));
		}
		return nameAttribute;
	}

	@GetMapping("/authorities")
	public List<String> getAuthorities(OAuth2AuthenticationToken authentication) {
		return authentication.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList());
	}


	public static void main(String[] args) {

		SpringApplication.run(Assignment2Application.class, args);

	}
}
