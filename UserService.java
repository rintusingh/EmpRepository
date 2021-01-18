package com.emp.mgmt.service;

import java.util.List;
import java.util.Optional;

import com.emp.mgmt.domain.User;
import com.emp.mgmt.exception.NonUniqueResourceException;
import com.emp.mgmt.exception.ResourceNotFoundException;

public interface UserService
{
    User createUser(User user) throws NonUniqueResourceException;


    User updateUser(User user) throws ResourceNotFoundException;


    Integer deleteUser(Integer userId) throws ResourceNotFoundException;


    Optional<User> getUser(Integer userId);


    List<User> getAllUser();


    Optional<User> getByUserName(String userName);
}
