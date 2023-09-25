package com.Micah.webapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
 
	public boolean authenticate(String userName,String pswd) {
		boolean isValidUserName = userName.equalsIgnoreCase("micah");
		boolean isValidPswd = pswd.equalsIgnoreCase("dummy");
		return isValidUserName && isValidPswd;
		
	}
}
