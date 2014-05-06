package com.tracker.model;

public class Authenticator {
	 
    public String authenticate(String username, String password) {
        if (("snehi23".equalsIgnoreCase(username))
                && ("snehi23".equals(password))) {
            return "success";
        } else {
            return "failure";
        }
    }
}
