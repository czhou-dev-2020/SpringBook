package com.rillsoft.springbookadmin.toolbox;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author crane
 *
 */

// https://www.cnblogs.com/xingzc/p/8624007.html

public class BCrypt {

	/**
	 * 
	 */
	public BCrypt() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(); 
 
		String strUserName = "admin";
//		String strPassword = "admin";
		String strPassword = "password";

//		strPassword = "password";

		String strDecPassword = bCryptPasswordEncoder.encode(strPassword); 
		System.out.println(strDecPassword); 
		
		if (bCryptPasswordEncoder.matches(strPassword, strDecPassword))
			System.out.println("Password matched");
		else
			System.out.println("Password NOT matched");
		
		if (bCryptPasswordEncoder.matches(strPassword, 
				"$2a$10$lVhoXUd0DlCNd671H6XnQOnTq0JqOmlm5FOEEygSHX2w4XH3lDp.m"))
			System.out.println("Password matched");
		else
			System.out.println("Password NOT matched");
		
		if (bCryptPasswordEncoder.matches(strPassword, 
				"$2a$10$ZskkmcTo0CHUpJSJAjcK2uZralenI1fhTulueA6OOJ/B8pIoPiNWa"))
			System.out.println("Password matched");
		else
			System.out.println("Password NOT matched");

		if (bCryptPasswordEncoder.matches(strPassword, 
				"$2a$10$9ld4aDq3zWwv4xvMYAHbe.3JNlb7gvvwdWgU0SODiRpHiFbgoNCaO"))
			System.out.println("Password matched");
		else
			System.out.println("Password NOT matched");
		if (bCryptPasswordEncoder.matches(strPassword,
				"$2a$10$GH2UACuX4b7sXXkOIy3/p./Xa6IP.P89nc9wxfwoT5Am2y2qmufR."))
			System.out.println("Password matched");
		else
			System.out.println("Password NOT matched");
		
		// Hash a password for the first time
//		String password = "testpassword";
//		String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
//		System.out.println(hashed);
//
//		// gensalt's log_rounds parameter determines the complexity
//		// the work factor is 2**log_rounds, and the default is 10
//		String hashed2 = BCrypt.hashpw(password, BCrypt.gensalt(12));
//			 
//		// Check that an unencrypted password matches one that has
//		// previously been hashed
//		String candidate = "testpassword";
//		//String candidate = "wrongtestpassword";
//		if (BCrypt.checkpw(candidate, hashed))
//		{
//			System.out.println("It matches");
//		}
//		else
//		{
//			System.out.println("It does not match");
//		}
	}
}
