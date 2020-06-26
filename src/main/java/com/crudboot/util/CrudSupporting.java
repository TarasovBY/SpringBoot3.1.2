package com.crudboot.util;

import com.crudboot.model.Role;
import com.crudboot.repository.RoleRepository;
import com.crudboot.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class CrudSupporting {

    private final RoleRepository roleRepository;

    public CrudSupporting(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Set<Role> createRole(WebRequest webRequest) {
        Set<Role> roleList = new HashSet<>();
        for(int a = 0; a < Objects.requireNonNull(webRequest.getParameterValues("roles")).length; a++ ) {
            roleList.add(roleRepository.findRoleByRole(Objects
                    .requireNonNull(webRequest.getParameterValues("roles"))[a]));
        }
        return roleList;
    }

}
