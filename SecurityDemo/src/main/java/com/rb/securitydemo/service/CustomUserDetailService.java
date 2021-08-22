package com.rb.securitydemo.service;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private static final Map<String, User> USERS = new HashMap<>();
    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void initData() {
        USERS.put("river_and_boat",
                new User(
                        "river_and_boat",
                        passwordEncoder.encode("123456"),
                        AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_admin")
                )
        );
        USERS.put("vary_zhang",
                new User(
                        "vary_zhang",
                        passwordEncoder.encode("19960128"),
                        AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_user")
                )
        );
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return USERS.get(username);
    }
}
