package com.hexkey.travelmaker.common.exception.member;

public class LoginFailedException extends Exception {
    public LoginFailedException(String msg){
        super(msg);
    }
}