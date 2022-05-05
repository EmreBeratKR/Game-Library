package com.scpg.gamelibrary.core.Message;

public final class ErrorMessage
{
    private ErrorMessage(){}

    public static final String UserDoesNotExist = "User does not Exist!";
    public static final String ZeroUser = "There are no Users to Show!";

    public static final String GameDoesNotExist = "Game does not Exist!";
    public static final String PublisherDoesNotExist = "Publisher does not Exist!";
    public static final String ZeroGame = "There are no Games to Show!";

    public static final String GameOwnershipDoesNotExist = "GameOwnership does not Exist!";
    public static final String ZeroGameOwned = "There are no Games to Show!";

    public static final String InvalidFriendship_Self = "User cannot add himself as Friend!";
    public static final String FriendshipAlreadyExists = "Friendship Already Exists!";
    public static final String FriendshipDoesNotExist = "Friendship does not Exist!";

    public static final String InvalidReview_EmptyContent = "Review Content must be filled!";
    public static final String ReviewDoesNotExist = "Review does not Exist!";
    public static final String ZeroReview = "There are no Reviews to Show!";


    public static String UserAlreadyExistByUsername(String username)
    {
        return "Username {" + username + "} is already taken!";
    }

    public static String UserAlreadyExistByMailAddress(String mailAddress)
    {
        return "MailAddress {" + mailAddress + "} is already in use!";
    }



    public static String TooLowGamePrice(double minPrice)
    {
        return "Game Price must be Equal or Higher than " + minPrice + "$!";
    }

    public static String TooHighGamePrice(double maxPrice)
    {
        return "Game Price must be Equal or Lower than " + maxPrice + "$!";
    }
}
