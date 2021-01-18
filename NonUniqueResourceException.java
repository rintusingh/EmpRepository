package com.emp.mgmt.exception;

public class NonUniqueResourceException extends Exception
{
    private static final long serialVersionUID = 1L;


    public NonUniqueResourceException()
    {
        super();
    }


    public NonUniqueResourceException(String msg)
    {
        super(msg);
    }


    public NonUniqueResourceException(Object msg)
    {
        super(msg.toString());
    }



}
