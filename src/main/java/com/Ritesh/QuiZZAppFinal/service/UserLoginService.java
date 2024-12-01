package com.Ritesh.QuiZZAppFinal.service;

import com.Ritesh.QuiZZAppFinal.entity.UserInfo;
import com.Ritesh.QuiZZAppFinal.repo.userInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService implements UserDetailsService {

    @Autowired
    private userInfoRepo userInfoRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("user not found"));
        // Add ROLE_ prefix to the role
        return User.withUsername(userInfo.getEmail())
                .password(userInfo.getPassword())
                .roles(userInfo.getRole())  // Ensure ROLE_ prefix
                .build();
    }
}