package com.rillsoft.springbookadmin.Service;


import com.rillsoft.springbookadmin.mapper.AuthRolesMapper;
import com.rillsoft.springbookadmin.model.AuthRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// @CacheConfig(cacheNames = "role")
@Service
public class AuthRolesService {

    @Autowired
    private AuthRolesMapper m_objAuthRolesMapper;

    /**
     *
     */
    public AuthRolesService() {
    }

    // @Cacheable(value = "all-role-list", key = "'rolelist'")
    public List<AuthRoles> getAllAuthRolesList() {
        return m_objAuthRolesMapper.selectAll();
    }
}
