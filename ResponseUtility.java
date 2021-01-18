package com.emp.mgmt.utility;

import com.emp.mgmt.data.ResponseData;

public class ResponseUtility
{

    public static <T> ResponseData<T> processResponse(T data, String message)
    {
        ResponseData<T> responseData = new ResponseData<T>();
        responseData
            .withData(data)
            .withMessage(message)
            .withStatus(UserConstants.STATUS_SUCCESS);

        return responseData;
    }

}
