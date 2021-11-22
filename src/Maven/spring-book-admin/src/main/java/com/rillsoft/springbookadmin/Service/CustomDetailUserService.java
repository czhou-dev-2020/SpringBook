package com.rillsoft.springbookadmin.Service;

// Refer to:
// https://github.com/spring-projects/spring-security/blob/main/core/src/main/java/org/springframework/security/
//      core/userdetails/UserDetailsService.java
// comment added by crane zhou on 2021.10.13

import com.rillsoft.springbookadmin.mapper.AuthUserRolesMapper;
import com.rillsoft.springbookadmin.mapper.AuthUsersMapper;
import com.rillsoft.springbookadmin.model.AuthRoles;
import com.rillsoft.springbookadmin.model.AuthUsers;
import com.rillsoft.springbookadmin.model.ExtendedAuthUsers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// comment added by crane zhou on 2021.10.27
// Refer to:
//      https://github.com/spring-projects/spring-security/blob/main/core/src/main/java/org/springframework/security/
//          core/userdetails/UserDetails.java
//      https://github.com/spring-projects/spring-security/blob/main/core/src/main/java/org/springframework/security/
//          core/userdetails/UserDetailsService.java
//
// comment added by crane zhou on 2021.11.01
// https://github.com/spring-projects/spring-security/blob/main/core/src/main/java/org/springframework/security/
//      access/AccessDecisionManager.java

@Service
public class CustomDetailUserService implements UserDetailsService {

    private static final Logger m_objLogger = LoggerFactory.getLogger(CustomDetailUserService.class);

    @Autowired
    private AuthUsersMapper m_objAuthUsersMapper;

    @Autowired
    private AuthUserRolesMapper m_objAuthUserRolesMapper;

    @Override
    public UserDetails loadUserByUsername(String strUsername) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        AuthUsers objTheAuthUser = m_objAuthUsersMapper.selectByUsername(strUsername);

        if (objTheAuthUser == null)
        {
            throw new UsernameNotFoundException("UserName " + strUsername + " not found");
        }
        else
        {
//            // we can use this in case we want to activate account after customer verified the account
//            boolean bEnabled = !objTheAuthUser.isAccountVerified();
//            SecurityAuthUsers objSecurityAuthUsers = User.withUsername(objTheAuthUser.getEmail())
//                    .password(objTheAuthUser.getPassword())
//                    .disabled(objTheAuthUser.isLoginDisabled())
//                    .authorities(getAuthorities(objTheAuthUser)).build()
//                    ;
//
//            return objSecurityAuthUsers;

            // we can use this in case we want to activate account after customer verified the account
//            boolean bEnabled = !objTheAuthUser.isAccountVerified();
//            m_objLogger.info("objTheAuthUser.getPassword()=" + objTheAuthUser.getPassword());
//            SecurityAuthUsers objSecurityAuthUsers = (SecurityAuthUsers) SecurityAuthUsers.withUsername(objTheAuthUser.getUsername())
//                    .password(objTheAuthUser.getPassword())
//                    .disabled(!objTheAuthUser.isLoginDisabled())
//                    .authorities(getAuthorities(objTheAuthUser)).build();

            // UserDetails objSecurityAuthUsers = User.withUsername(objTheAuthUser.getUsername())
//            SecurityAuthUsers objSecurityAuthUsers = (SecurityAuthUsers) SecurityAuthUsers.withUsername(objTheAuthUser.getUsername())
            ExtendedAuthUsers objExtendAuthUsers = (ExtendedAuthUsers) ExtendedAuthUsers.withUsername(objTheAuthUser.getUsername())
                    .password(objTheAuthUser.getPassword())
                    .disabled(!objTheAuthUser.isLoginDisabled())
                    .authorities(getAuthorities(objTheAuthUser))
                    .setupAuthUsers(objTheAuthUser).build();

//            objExtendAuthUsers.setAuthUsers(objTheAuthUser);
//            SecurityAuthUsers objSecurityAuthUsers = new SecurityAuthUsers(objTheAuthUser);

            return objExtendAuthUsers;

        }
    }

    public List<AuthUsers> getAllAuthUsersList() {
        return m_objAuthUsersMapper.selectAll();
    }

    private Collection<GrantedAuthority> getAuthorities(AuthUsers objTheAuthUser){
        List <AuthRoles> objTheAuthRoles = m_objAuthUserRolesMapper.selectAuthRolesByUserId(objTheAuthUser.getId());
        Collection<GrantedAuthority> objAuthorities = new ArrayList<>(objTheAuthRoles.size());
        for(AuthRoles objUserRole : objTheAuthRoles){
            objAuthorities.add(new SimpleGrantedAuthority(objUserRole.getRoleCode().toUpperCase()));
        }
        return objAuthorities;
    }

//    private Collection<GrantedAuthority> getAuthorities(AuthUsers objTheAuthUser){
//        Set <AuthRoles> objUserRoles = objTheAuthUser.getAuthUserRoles();
//        Collection<GrantedAuthority> objAuthorities = new ArrayList<>(objUserRoles.size());
//        for(AuthRoles objUserRole : objUserRoles){
//            objAuthorities.add(new SimpleGrantedAuthority(objUserRole.getRoleName().toUpperCase()));
//        }
//
//        return objAuthorities;
//    }
    
}
