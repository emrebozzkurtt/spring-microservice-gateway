package com.emrebozzkurtt.microservicegateway.service;

import com.emrebozzkurtt.microservicegateway.model.User;
import com.emrebozzkurtt.microservicegateway.security.UserPrincipal;
import com.emrebozzkurtt.microservicegateway.security.jwt.IJwtProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final IJwtProvider jwtProvider;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, IJwtProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public String signInAndReturnJwt(User signInRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(),signInRequest.getPassword())
        );
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        return jwtProvider.generateToken(userPrincipal);
    }

}
