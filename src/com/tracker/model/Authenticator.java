package com.tracker.model;

public class Authenticator {
	 
    public String authenticate(String username, String password) {
        if (("snehal".equalsIgnoreCase(username))
                && ("snehal".equals(password))) {
            return "success";
        } else {
            return "failure";
        }
    }
}
