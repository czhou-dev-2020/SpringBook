
package com.rillsoft.springbookadmin.toolbox;

import java.security.KeyPair; 
import java.security.KeyPairGenerator; 
import java.security.interfaces.RSAPrivateKey; 
import java.security.interfaces.RSAPublicKey; 
import javax.crypto.Cipher; 

/**
 * @author crane
 *
 */

// https://www.jianshu.com/p/93e4cbd90a2f
	
public class RSA { 
	public static byte[] encrypt(RSAPublicKey publicKey,byte[] srcBytes) throws Exception { 
		if(publicKey!=null) { 
			Cipher cipher = Cipher.getInstance("RSA"); cipher.init(Cipher.ENCRYPT_MODE, publicKey); 
			byte[] resultBytes = cipher.doFinal(srcBytes); 
			return resultBytes; 
		} 
		return null; 
	} 
	
	public static byte[] decrypt(RSAPrivateKey privateKey,byte[] srcBytes) throws Exception { 
		if(privateKey!=null) { 
			Cipher cipher = Cipher.getInstance("RSA"); 
			cipher.init(Cipher.DECRYPT_MODE, privateKey); 
			byte[] resultBytes = cipher.doFinal(srcBytes); 
			
			return resultBytes; 
		} return null; 
	} 
	
    public static String bytesToHexFun3(byte[] bytes) {
        StringBuilder buf = new StringBuilder(bytes.length * 2);
        for(byte b : bytes) {
        	// Use String.format() to convert
			// Integer(int) in java.lang.Integer has been deprecated
			// buf.append(String.format("%02x", new Integer(b & 0xff)));
			buf.append(String.format("%02x", b & 0xff));
        }

        return buf.toString();
    }

	public static void main(String[] args) throws Exception { 
		
		String msg = "message encrypted in java";
		
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA"); 
		keyPairGen.initialize(1024); 
		KeyPair keyPair = keyPairGen.generateKeyPair(); 
		RSAPrivateKey privateKey = (RSAPrivateKey)keyPair.getPrivate(); 
		RSAPublicKey publicKey = (RSAPublicKey)keyPair.getPublic(); 
		byte[] srcBytes = msg.getBytes(); 
		byte[] resultBytes = RSA.encrypt(publicKey, srcBytes); 
		byte[] decBytes = RSA.decrypt(privateKey, resultBytes); 
		
//		System.out.println("明文:" + msg); 
//		System.out.println("密文:" + new String(resultBytes)); 
//		System.out.println("解密:" + new String(decBytes)); 
		System.out.println("Plain Text:" + msg); 
		System.out.println("Cipher Text:" + new String(resultBytes)); 

		System.out.println("Cipher Text Length:" + resultBytes.length);
		System.out.println("Cipher Text:" + bytesToHexFun3(resultBytes));
		
		System.out.println("Decryption :" + new String(decBytes)); 
	} 	
}
