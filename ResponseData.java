package com.emp.mgmt.data;

public class ResponseData<T>
{
    private String status;
    private String message;
    private T data;


    public ResponseData()
    {
        super();
    }


    public ResponseData(String status, String message, T data)
    {
        super();
        this.status = status;
        this.message = message;
        this.data = data;
    }


    public String getStatus()
    {
        return status;
    }


    public void setStatus(String status)
    {
        this.status = status;
    }


    public ResponseData<T> withStatus(String status)
    {
        setStatus(status);
        return this;
    }


    public String getMessage()
    {
        return message;
    }


    public void setMessage(String message)
    {
        this.message = message;
    }


    public ResponseData<T> withMessage(String message)
    {
        setMessage(message);
        return this;
    }


    public T getData()
    {
        return data;
    }


    public void setData(T data)
    {
        this.data = data;
    }


    public ResponseData<T> withData(T data)
    {
        setData(data);
        return this;
    }


    @Override
    public String toString()
    {
        return "ResponseData [status=" + status + ", message=" + message + ", data=" + data + "]";
    }

}
