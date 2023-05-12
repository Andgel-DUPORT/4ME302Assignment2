package com.AndgelDuport.Assignment2.controllers;

import com.AndgelDuport.Assignment2.dao.model.Organization;
import com.AndgelDuport.Assignment2.dao.model.Role;
import com.AndgelDuport.Assignment2.dao.model.User;
import com.AndgelDuport.Assignment2.dao.model.UserRole;
import com.AndgelDuport.Assignment2.dao.repositories.OrganizationRepository;
import com.AndgelDuport.Assignment2.dao.repositories.RoleRepository;
import com.AndgelDuport.Assignment2.dao.repositories.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
@PreAuthorize("hasAnyRole('ADMIN')")
public class UserController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final OrganizationRepository organizationRepository;

    public UserController(UserRepository userRepository, RoleRepository roleRepository, OrganizationRepository organizationRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.organizationRepository = organizationRepository;
    }


    @GetMapping("/user")
    @ResponseBody String user(@AuthenticationPrincipal OAuth2User connected) {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        return a.toString();
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepository.findAll();
        List<UserRole> userRoleList= new ArrayList<>();
        for (User user:listUsers){
            Role role = roleRepository.findByRoleID(user.getRole_IDrole()).orElseThrow(null);
            Organization organization = organizationRepository.findByOrganizationID(user.getOrganization()).orElseThrow(null);
            UserRole userRole = new UserRole(user.getId(), user.getUsername(), user.getEmail(),user.getRole_IDrole(), user.getOrganization(), user.getLat(), user.getLon(), role.getName(), organization.getName());
            userRoleList.add(userRole);
        }
        model.addAttribute("listUsers", userRoleList);
        return "users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        Optional<User> user = userRepository.findById(id);
        List<Role> listRoles = roleRepository.findAll();
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        return "user_form";
    }
}
