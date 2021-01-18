package com.emp.mgmt.controller.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.emp.mgmt.data.ResponseData;
import com.emp.mgmt.exception.NonUniqueResourceException;
import com.emp.mgmt.exception.ResourceNotFoundException;
import com.emp.mgmt.utility.UserConstants;

@ControllerAdvice
public class GlobalExceptionHandler
{

    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseData<String>> handleNotFound(Exception exception)
    {
        log.error("Exception Occured : " + exception.getMessage());

        ResponseData<String> responseData = new ResponseData<>();

        responseData
            .withMessage(exception.getMessage())
            .withStatus(UserConstants.STATUS_FAILURE)
            .setData(UserConstants.RESOURCE_NOT_FOUND);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseData);
    }


    @ExceptionHandler(NonUniqueResourceException.class)
    public ResponseEntity<ResponseData<String>> handleAlreadyExists(Exception exception)
    {
        log.error("Exception Occured : " + exception.getMessage());

        ResponseData<String> responseData = new ResponseData<>();

        responseData
            .withMessage(exception.getMessage())
            .withStatus(UserConstants.STATUS_FAILURE)
            .setData(UserConstants.NON_UNIQUE_RESOURCE);

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(responseData);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseData<String>> handleGeneric(Exception exception)
    {
        log.error("Exception Occured : " + exception.getMessage());

        ResponseData<String> responseData = new ResponseData<>();

        responseData
            .withMessage(exception.getMessage())
            .withStatus(UserConstants.STATUS_FAILURE)
            .setData(UserConstants.RESOURCE_NOT_FOUND);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }
}
