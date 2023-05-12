package com.AndgelDuport.Assignment2.services;

import com.AndgelDuport.Assignment2.dao.model.Role;
import com.AndgelDuport.Assignment2.dao.model.User;
import com.AndgelDuport.Assignment2.dao.repositories.RoleRepository;
import com.AndgelDuport.Assignment2.dao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GoogleOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        // Get user profile information from the Google OAuth2 API
        DefaultOAuth2UserService defaultOAuth2UserService = new DefaultOAuth2UserService();
        OAuth2User oauth2User = defaultOAuth2UserService.loadUser(userRequest);

        // Extract user email and other details from the user profile
        String email = oauth2User.getAttribute("email");
        String name = oauth2User.getAttribute("name");

        // Check if user already exists in the database
        Optional<User> optionalUser = userRepository.findByEmail(email);
        User user;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        } else {
            // Create a new user and save to the database
            user = new User();
            user.setEmail(email);
            user.setUsername(name);
            user.setOrganization(1);
            user.setRole_IDrole(1);
            userRepository.save(user);
        }

        // Create a Principal object with the necessary details and authorities
        OAuth2UserAuthority authority = new OAuth2UserAuthority(roleRepository.findByRoleID(user.getRole_IDrole()).get().getName(), oauth2User.getAttributes());
        Set<GrantedAuthority> combinedAuthorities = new HashSet<>();
        combinedAuthorities.add(authority);
        userRequest.getAccessToken();
        return new DefaultOAuth2User(combinedAuthorities, oauth2User.getAttributes(), "email");
    }

    private Set<GrantedAuthority> getUserAuthorities(String email) {
        // Query the database or any other source to get the user's roles
        Optional<User> user = userRepository.findByEmail(email);
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (Role role : user.get().getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

}