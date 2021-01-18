package com.emp.mgmt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emp.mgmt.data.ResponseData;
import com.emp.mgmt.domain.User;
import com.emp.mgmt.exception.NonUniqueResourceException;
import com.emp.mgmt.exception.ResourceNotFoundException;
import com.emp.mgmt.service.UserService;
import com.emp.mgmt.utility.ResponseUtility;
import com.emp.mgmt.utility.UserConstants;

@RestController
@RequestMapping("/usermgmt")
public class EmployeeController
{

    @Autowired
    private UserService userService;


    @PostMapping("/users")
    public ResponseData<User> createUser(@RequestBody User user) throws NonUniqueResourceException
    {
        User persistedUser = userService.createUser(user);
        return ResponseUtility.processResponse(persistedUser, UserConstants.SAVE_SUCCESS_MSG);
    }


    @PutMapping("/users")
    public ResponseData<User> updateUser(@RequestBody User user) throws ResourceNotFoundException
    {
        User updatedUser = userService.updateUser(user);
        return ResponseUtility.processResponse(updatedUser, UserConstants.UPDATE_SUCCESS_MSG);
    }


    @DeleteMapping("/users/{id}")
    public ResponseData<Integer> deleteUser(@PathVariable(value = "id") Integer userId) throws ResourceNotFoundException
    {
        Integer deletedUserId = userService.deleteUser(userId);
        return ResponseUtility.processResponse(deletedUserId, UserConstants.DELETE_SUCCESS_MSG);
    }


    @GetMapping("/users/{id}")
    public ResponseData<Optional<User>> getUser(@PathVariable(value = "id") Integer userId)
    {
        Optional<User> retrievedUser = userService.getUser(userId);
        return ResponseUtility.processResponse(retrievedUser, UserConstants.RETRIEVE_SUCCESS_MSG);
    }


    @GetMapping(value = "/users")
    public ResponseData<List<User>> getAllUser()
    {
        List<User> userList = userService.getAllUser();
        return ResponseUtility.processResponse(userList, UserConstants.RETRIEVE_SUCCESS_MSG);
    }


    @GetMapping("/users/name/{userName}")
    public ResponseData<Optional<User>> getByUserName(@RequestParam(value = "userName") String userName)
    {
        Optional<User> retrievedUser = userService.getByUserName(userName);
        return ResponseUtility.processResponse(retrievedUser, UserConstants.RETRIEVE_SUCCESS_MSG);
    }

}
