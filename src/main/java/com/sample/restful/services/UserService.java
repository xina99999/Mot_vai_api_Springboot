package com.sample.restful.services;

import com.sample.restful.entities.User;

import com.sample.restful.models.requests.SaveUserRequest;


import java.util.List;

public interface UserService {
    User findById(Long id);

    List<User> findAll();

    User save(SaveUserRequest request);

    void delete(User user);

    User findByUserName(String UserName);

}
