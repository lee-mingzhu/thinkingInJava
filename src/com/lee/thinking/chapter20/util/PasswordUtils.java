package com.lee.thinking.chapter20.util;

import com.lee.thinking.chapter20.anno.UserCase;

import java.util.List;

/**
 * Created by mingzhu on 2016/7/13.
 */
public class PasswordUtils {

    @UserCase(id = 47, description = "Password must contain at least one numeric")
    public boolean validatePassword(String password){
        return (password.matches("\\w*\\d\\w*"));
    }

    @UserCase(id = 48)
    public String encryptPassword(String password){
        return new StringBuffer(password).reverse().toString();
    }

    @UserCase(id = 49, description = "New passwords can't equal previously used ones")
    public boolean checkForNewPassword(List<String> prevPasswords, String password){
        return !prevPasswords.contains(password);
    }
}
