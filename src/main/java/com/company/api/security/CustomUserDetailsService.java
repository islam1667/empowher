package com.company.api.security;

import com.company.api.exception.UserNotVerifiedException;
import com.company.api.models.UserEntity;
import com.company.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException,UserNotVerifiedException {
//        UserEntity user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
//        if(!user.getEnabled()) throw new UserNotVerifiedException("User is not verified");
//        return new User(user.getUsername(), user.getPassword(), List.of(new SimpleGrantedAuthority(user.getRole().toString())));
//    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException,UserNotVerifiedException {
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        if(!user.getEnabled()) throw new UserNotVerifiedException("User is not verified");
        System.out.println("returning user object");
        return new User(user.getUsername(), user.getPassword(), List.of(new SimpleGrantedAuthority(user.getRole().toString())));
    }

//    private Collection<GrantedAuthority> mapRolesToAuthorities(UserRole role){
//        return roles.stream().map(role -> new SimpleGrantedAuthority(role.)).collect(Collectors.toList());
//    }
}
