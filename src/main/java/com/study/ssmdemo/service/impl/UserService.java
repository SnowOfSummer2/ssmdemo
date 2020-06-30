package com.study.ssmdemo.service.impl;


import com.study.ssmdemo.dao.AccountRepository;
import com.study.ssmdemo.domain.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class UserService implements UserDetailsService {

    private AccountRepository repository;

    public UserService(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Account account = repository.findByName(s);

        if (account == null)
            throw new UsernameNotFoundException("User " + s + " not found");

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        return new User("admin", new BCryptPasswordEncoder().encode(account.getPassword()), authorities);

    }
}
