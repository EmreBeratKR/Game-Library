package com.scpg.gamelibrary.core.Message;

public final class ErrorMessage
{
    private ErrorMessage(){}

    public static final String UserDoesNotExist = "User does not Exist!";
    public static final String ZeroUser = "There are no Users to Show!";


    public static String UserAlreadyExistByUsername(String username)
    {
        return "Username {" + username + "} is already taken!";
    }

    public static String UserAlreadyExistByMailAddress(String mailAddress)
    {
        return "MailAddress {" + mailAddress + "} is already in use!";
    }
}
