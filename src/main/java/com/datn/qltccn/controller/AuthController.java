package com.datn.qltccn.controller;

import com.datn.qltccn.common.Constant;
import com.datn.qltccn.dto.LoginDTO;
import com.datn.qltccn.security.UserLockedException;
import com.datn.qltccn.security.UserMissingRoleException;
import com.datn.qltccn.security.UserNotActivatedException;
import com.datn.qltccn.security.UserTokenInvalidException;
import com.datn.qltccn.security.jwt.JWTFilter;
import com.datn.qltccn.security.jwt.TokenProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RequestMapping("/api")
@RestController
public class AuthController {
    private final Logger log = LoggerFactory.getLogger(AuthController.class);

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    private final TokenProvider tokenProvider;


    public AuthController(AuthenticationManagerBuilder authenticationManagerBuilder,
                          TokenProvider tokenProvider) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authorize(@Validated @RequestBody LoginDTO loginDTO) {
        log.info("REST request to authenticate user: {}", loginDTO);
        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());
            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            boolean rememberMe = loginDTO.isRememberMe();
            String jwt = tokenProvider.createToken(authentication, rememberMe);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, String.format("Bearer %s", jwt));
            return new ResponseEntity<>(Collections.singletonMap("id_token", jwt), httpHeaders, HttpStatus.OK);
        } catch (Exception ex){
            return handleError(ex);
        }
    }

    private ResponseEntity<Object> handleError(Exception ex) {
        log.error(ex.getMessage(), ex);
        Throwable cause = ex.getCause();
        if(cause instanceof UserNotActivatedException) {
            return new ResponseEntity<>(Collections.singletonMap(Constant.MESSAGE,
                    Constant.USER_NOT_ACTIVE), HttpStatus.UNAUTHORIZED);
        } else if(cause instanceof UserLockedException) {
            return new ResponseEntity<>(Collections.singletonMap(Constant.MESSAGE,
                    Constant.USER_LOCKED), HttpStatus.UNAUTHORIZED);
        } else if(cause instanceof UsernameNotFoundException) {
            return new ResponseEntity<>(Collections.singletonMap(Constant.MESSAGE,
                    Constant.USER_NOT_FOUND), HttpStatus.UNAUTHORIZED);
        } else if(ex instanceof UserMissingRoleException) {
            return new ResponseEntity<>(Collections.singletonMap(Constant.MESSAGE,
                    Constant.USER_MISSING_ROLE), HttpStatus.OK);
        } else if(ex instanceof UserTokenInvalidException) {
            return new ResponseEntity<>(Collections.singletonMap(Constant.MESSAGE,
                    Constant.USER_TOKEN_INVALID), HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

}
