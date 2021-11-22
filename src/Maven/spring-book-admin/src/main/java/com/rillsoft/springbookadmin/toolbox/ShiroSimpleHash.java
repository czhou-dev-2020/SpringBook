
package com.rillsoft.springbookadmin.toolbox;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

// import com.rillsoft.stackpo.domain.User;
import com.rillsoft.springbookadmin.toolbox.ShiroSimpleHash;

// import org.apache.shiro.crypto.RandomNumberGenerator;
// import org.apache.shiro.crypto.SecureRandomNumberGenerator;

/**
 * @author crane
 *
 */

// https://github.com/coder-yqj/springboot-shiro/blob/master/src/main/java/com/study/util/PasswordHelper.java

public class ShiroSimpleHash {
	
	// private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	
	private String algorithmName = "MD5";
	private int hashIterations = 2;

	public String encryptPassword(String strUserName, String strPassword) {
		
		// String salt=randomNumberGenerator.nextBytes().toHex();

		String strDecPassword = new SimpleHash(algorithmName, 
												strPassword,  
												ByteSource.Util.bytes(strUserName), 
												hashIterations).toHex();
		
//		System.out.println("ShiroSimpleHash:encryptPassword() strDecPassword=" + strDecPassword);
		
		return strDecPassword;

	}

	public static void main(String[] args) {
		
		ShiroSimpleHash passwordGenerator = new ShiroSimpleHash();

//		user.setUsername("crane_zhou");
//		user.setPassword("password");
		
		String strUserName = "admin";
//		String strPassword = "admin";
		String strPassword = "password";
		
		String strDecPassword = passwordGenerator.encryptPassword(strUserName, strPassword);
		
		System.out.println("Cipher Text:" + strDecPassword);
	}
}
