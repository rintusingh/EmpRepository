package com.emp.mgmt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.mgmt.domain.User;
import com.emp.mgmt.exception.NonUniqueResourceException;
import com.emp.mgmt.exception.ResourceNotFoundException;
import com.emp.mgmt.repository.UserRepository;
import com.emp.mgmt.service.UserService;
import com.emp.mgmt.utility.UserConstants;

@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserRepository userRepository;


    @Override
    public final User createUser(final User user) throws NonUniqueResourceException
    {
        userRepository.findById(user.getUserId()).ifPresent(NonUniqueResourceException::new);
        return userRepository.save(user);
    }


    //TODO
    @Override
    public final User updateUser(final User user) throws ResourceNotFoundException
    {
        User retrievedUser = userRepository.findById(user.getUserId()).orElseThrow(() -> new ResourceNotFoundException(UserConstants.USER_NOT_FOUND_FOR_UPDATE));

        Integer contactId = retrievedUser.getUserContact().getContactId();
        Integer passwordId = retrievedUser.getUserPassword().getPasswordId();

        retrievedUser.setFirstName(user.getFirstName());
        retrievedUser.setLastName(user.getLastName());
        retrievedUser.setStatus(user.getStatus());
        retrievedUser.setUserContact(user.getUserContact());
        retrievedUser.setUserPassword(user.getUserPassword());
        retrievedUser.setUserPhoto(user.getUserPhoto());

        retrievedUser.getUserContact().setContactId(contactId);
        retrievedUser.getUserPassword().setPasswordId(passwordId);

        return userRepository.save(retrievedUser);
    }


    @Override
    public final Optional<User> getUser(final Integer userId)
    {
        return userRepository.findById(userId);
    }


    @Override
    public final List<User> getAllUser()
    {
        return userRepository.findAll();
    }


    @Override
    public final Integer deleteUser(final Integer userId) throws ResourceNotFoundException
    {
        userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(UserConstants.USER_NOT_EXISTS));
        userRepository.deleteById(userId);
        return userId;
    }


    @Override
    public final Optional<User> getByUserName(String userName)
    {
        return userRepository.findByUserName(userName);
    }

}
