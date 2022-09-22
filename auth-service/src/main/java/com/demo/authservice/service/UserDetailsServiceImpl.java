package com.demo.authservice.service;

import com.demo.authservice.dto.CustomUserDetails;
import com.demo.authservice.entity.User;
import com.demo.authservice.repositories.RoleRepository;
import com.demo.authservice.repositories.UserRepository;
import com.demo.authservice.utils.Const;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService {
    private final Logger logger = LogManager.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            logger.info("User not found with email : {}",email);
            throw new UsernameNotFoundException("User not found");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (String roleName : roleRepository.findRoleNameByUserId(user.getId())) {
            grantedAuthorities.add(new SimpleGrantedAuthority(roleName));
        }
        boolean enable = user.getStatus() == Const.UserStatus.ACTIVE ? true : false;
        CustomUserDetails customUserDetails = new CustomUserDetails(user.getEmail(), user.getPassword(), enable, grantedAuthorities);
        customUserDetails.setId(user.getId());
        customUserDetails.setName(user.getName());
        customUserDetails.setPhone(user.getPhone());
        return customUserDetails;
    }
}
