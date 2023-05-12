package com.AndgelDuport.Assignment2.services;

import com.AndgelDuport.Assignment2.dao.model.Role;
import com.AndgelDuport.Assignment2.dao.model.User;
import com.AndgelDuport.Assignment2.dto.CustomRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class UserService {

    public List<String> getRoleNamesForUser(User user) {
        List<String> roleName = null;

        if (user != null) {
            Set<Role> roles;
            roles = user.getRoles();
            if (!roles.isEmpty()) {
                roles.forEach(role -> {
                    assert false;
                    roleName.add(role.getName());
                });
            }
        }
        return roleName;
    }

    public Collection<GrantedAuthority> getAuthoritiesForUser(User user) {
        List<String> roleNames = getRoleNamesForUser(user);
        return roleNames.stream()
                .map(CustomRole::new)
                .collect(Collectors.toList());
    }
}
