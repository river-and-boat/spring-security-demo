package com.rb.authorizationservice.service;

import com.rb.authorizationservice.model.User;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private static final Map<String, User> USER_MAP = new HashMap<>();
    private final PasswordEncoder passwordEncoder;

    public UserService(final PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void initData() {
        USER_MAP.put("river_and_boat", new User(
                "river_and_boat",
                passwordEncoder.encode("123456"),
                AuthorityUtils.createAuthorityList("admin"))
        );
        USER_MAP.put("vera_zhang", new User(
                "vera_zhang",
                passwordEncoder.encode("19960128"),
                AuthorityUtils.createAuthorityList("user"))
        );
        USER_MAP.put("dai_head", new User(
                "dai_head",
                passwordEncoder.encode("012345"),
                AuthorityUtils.createAuthorityList("none"))
        );
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return USER_MAP.get(username);
    }
}
