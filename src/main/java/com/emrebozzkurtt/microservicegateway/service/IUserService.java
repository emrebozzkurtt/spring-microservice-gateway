package com.emrebozzkurtt.microservicegateway.service;

import com.emrebozzkurtt.microservicegateway.model.User;

import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    Optional<User> findByUsername(String username);
}
