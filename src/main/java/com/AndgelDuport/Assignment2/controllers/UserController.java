package com.AndgelDuport.Assignment2.controllers;

import com.AndgelDuport.Assignment2.dao.repositories.OrganizationRepository;
import com.AndgelDuport.Assignment2.dao.repositories.RoleRepository;
import com.AndgelDuport.Assignment2.dao.repositories.UserRepository;
import com.AndgelDuport.Assignment2.model.Organization;
import com.AndgelDuport.Assignment2.model.Role;
import com.AndgelDuport.Assignment2.model.User;
import com.AndgelDuport.Assignment2.model.UserRole;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping
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
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User connected) {
        return Collections.singletonMap("Attributes", (connected.getAttributes()));
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepository.findAll();
        List<UserRole> userRoleList= new ArrayList<>();
        for (User user:listUsers){
            Role role = roleRepository.findById(user.getRole_IDrole()).orElseThrow(null);
            Organization organization = organizationRepository.findById(Long.valueOf(user.getOrganization())).orElseThrow(null);
            UserRole userRole = new UserRole(user.getId(), user.getUsername(), user.getEmail(),user.getRole_IDrole(), user.getOrganization(), user.getLat(), user.getLong(), role.getName(), organization.getName());
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
