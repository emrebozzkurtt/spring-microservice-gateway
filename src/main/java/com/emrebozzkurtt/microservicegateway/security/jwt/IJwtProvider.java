package com.emrebozzkurtt.microservicegateway.security.jwt;

import com.emrebozzkurtt.microservicegateway.security.UserPrincipal;

public interface IJwtProvider {
    String generateToken(UserPrincipal authentication);
}
