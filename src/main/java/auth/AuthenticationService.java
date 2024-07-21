package auth;

import user.User;
import user.UserService;

public class AuthenticationService {
    public final static String USER_NOT_FOUND = "User not found", USER_EXISTS = "User exist", WRONG_PASSWORD = "Wrong password", SUCCESS = "Success", FAILURE = "Failure";
    public static UserService userService;

    public static void initService(){
        userService=new UserService();
    }

    public static void destroyService(){
        userService=null;
    }

    public static String register(String username, String password) {
        User user = userService.findByName(username);
        if (user != null) {
            return USER_EXISTS;
        }
        if (!userService.insert(new User(username, password))) {
            return FAILURE;
        }
        return SUCCESS;
    }

    public static AuthData login(String username, String password) {
        User user = userService.findByName(username);
        AuthData data=new AuthData(SUCCESS,null);
        
        if (user == null) {
        	data.message=USER_NOT_FOUND;
            return data;
        }

        if (!user.getPassword().equals(password)) {
        	data.message=WRONG_PASSWORD;
            return data;
        }
        
        data.user=user;
        return data;
    }

}
