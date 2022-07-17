package com.emlakjet.reportservice.utils;

//To store the UserContext in a ThreadLocal variable that is
// accessible by any method invoked by the thread processing the user’s request.
public class UserContextHolder {
    private static final ThreadLocal<UserContext> userContext = new ThreadLocal<UserContext>();

    public static UserContext getContext(){
        UserContext context = userContext.get();

        if (context == null){
            context = newUserContext();
            userContext.set(context);
        }

        return context;
    }

    private static UserContext newUserContext(){
        return new UserContext();
    }
}
