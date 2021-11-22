package com.rillsoft.springbookadmin.Service;

import com.rillsoft.springbookadmin.mapper.AuthGroupsMapper;
import com.rillsoft.springbookadmin.mapper.AuthRolesMapper;
import com.rillsoft.springbookadmin.model.AuthGroups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthGroupsService {
    @Autowired
    private AuthGroupsMapper m_objAuthGroupsMapper;

    /**
     *
     */
    public AuthGroupsService() {
    }

    // @Cacheable(value = "all-role-list", key = "'rolelist'")
    public List<AuthGroups> getAllAuthGroupsList() {
        return m_objAuthGroupsMapper.selectAll();
    }
}
