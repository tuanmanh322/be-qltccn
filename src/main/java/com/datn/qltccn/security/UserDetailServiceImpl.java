package com.datn.qltccn.security;

import com.datn.qltccn.model.Role;
import com.datn.qltccn.model.User;
import com.datn.qltccn.repository.RoleRepository;
import com.datn.qltccn.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component("userDetailServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {
    private final Logger log = LoggerFactory.getLogger(UserDetailServiceImpl.class);

    private final UserRepository userRepository;

    private final RoleRepository rolesRepository;

    public UserDetailServiceImpl(UserRepository userRepository, RoleRepository rolesRepository) {
        this.userRepository = userRepository;
        this.rolesRepository = rolesRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.trace("Service authenticate: {}", username);
        try {
            User the = userRepository.findByUsername(username);
//            if (!the.getActive())
//                throw new UserNotActivatedException("User: " + username + " was not activated");
            Role role = rolesRepository.findById(the.getIdRole()).get();
            List<GrantedAuthority> grantedAuthorities = Stream.of(role.getNameRole())
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
            UserDetails userDetails = new UserDetails(the.getUsername(), the.getPass(), grantedAuthorities);
            the.setPass(null);
            userDetails.setUser(the);
            return userDetails;
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            throw new UsernameNotFoundException("User with user " + username + " not found in the database");
        }
    }
}
