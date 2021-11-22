package com.rillsoft.springbookadmin.toolbox;

import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

/**
 * @author crane
 *
 */

// https://www.jianshu.com/p/93e4cbd90a2f

public class MD5 { 
	public static byte[] eccrypt(String info) throws NoSuchAlgorithmException { 
		
		// Get MessageDigest Object (Instance) of MD5
		MessageDigest md5 = MessageDigest.getInstance("MD5"); 
		
		byte[] srcBytes = info.getBytes(); 
		md5.update(srcBytes); 
		byte[] resultBytes = md5.digest(); 
		
		return resultBytes; 
		
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
	
	public static void main(String args[]) throws NoSuchAlgorithmException { 
		
		String msg = "message encrypted in java";
		
		byte[] resultBytes = MD5.eccrypt(msg); 
//		System.out.println("密文：" + new String(resultBytes)); 
//		System.out.println("明文：" + msg);
		
		System.out.println("Plain Text:" + msg); 
		System.out.println("Cipher Text:" + new String(resultBytes)); 

		System.out.println("Cipher Text Length:" + resultBytes.length);
		System.out.println("Cipher Text:" + bytesToHexFun3(resultBytes));
		
//		System.out.println("Decryption :" + new String(decBytes));
	} 	
}

