package com.rillsoft.springbookadmin.toolbox;

import java.nio.charset.Charset;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

import java.util.Arrays;
import java.util.Map;

/**
 * @author crane
 *
 */

// https://www.jianshu.com/p/93e4cbd90a2f

public class SHA { 
	
	public static byte[] eccrypt(String shaType,String info) throws NoSuchAlgorithmException { 
		MessageDigest md5 = MessageDigest.getInstance(shaType); 
		
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
    
    private static void printAvailableCharsets() {
        Map<String ,Charset> map = Charset.availableCharsets();
        System.out.println("the available Charsets supported by jdk:"+map.size());
        for (Map.Entry<String, Charset> entry :
                map.entrySet()) {
            System.out.println(entry.getKey());
        }
    }

	/** * @param args * @throws NoSuchAlgorithmException */ 
	public static void main(String[] args) throws NoSuchAlgorithmException { 
		
		// String msg = "皇子讲java密码技术";
		String msg = "message encrypted in java";
		
		String[] shaTypes = new String[] { "SHA1", "SHA-256", "SHA-384", "SHA-512" }; 
		
//		printAvailableCharsets();
/*		
		String strTest = "aKTest";
//		String strTest = "测试";
		byte[] bytes = strTest.getBytes();
        System.out.println("字节数组为：" + Arrays.toString(bytes));
        System.out.println("字节数组长度为：" + bytes.length);
        
        System.out.println(String.format("%02x,%02x", bytes[0], bytes[1]));
        System.out.println("bytesToHexFun3:" + bytesToHexFun3(bytes));
*/
		
		for(String shaType : shaTypes) { 
			System.out.println(shaType); 
			byte[] resultBytes = SHA.eccrypt(shaType,msg); 
			
//			System.out.println("明文：" + msg); 
//			System.out.println("密文：" + new String(resultBytes)); 
//			System.out.println("========================");
			
			System.out.println("Plain Text:" + msg); 
			System.out.println("Plain Text Length:" + msg.getBytes().length);
			
			System.out.println("Cipher Text:" + new String(resultBytes)); 
			System.out.println("Cipher Text Length:" + resultBytes.length);
			
			System.out.println("Cipher Text:" + bytesToHexFun3(resultBytes));
			
			System.out.println("========================");
		}
	} 
}

