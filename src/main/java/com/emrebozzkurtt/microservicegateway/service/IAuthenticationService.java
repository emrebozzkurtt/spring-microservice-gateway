package com.emrebozzkurtt.microservicegateway.service;

import com.emrebozzkurtt.microservicegateway.model.User;

public interface IAuthenticationService {
    String signInAndReturnJwt(User signInRequest);
}
