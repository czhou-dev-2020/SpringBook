package com.rillsoft.springbookadmin.toolbox;

import java.security.KeyFactory; 
import java.security.KeyPair;
import java.security.KeyPairGenerator; 
import java.security.PrivateKey; 
import java.security.PublicKey; 
import java.security.Signature; 
import java.security.interfaces.RSAPrivateKey; 
import java.security.interfaces.RSAPublicKey; 
import java.security.spec.PKCS8EncodedKeySpec;

/**
 * @author crane
 *
 */

// https://www.jianshu.com/p/93e4cbd90a2f

public class RSASign { 
	public static byte[] sign(PrivateKey rsaPrivateKey,String msg) throws Exception { 
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded()); 
		KeyFactory keyFactory = KeyFactory.getInstance("RSA"); 
		PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec); 
		Signature signature = Signature.getInstance("MD5withRSA"); 
		signature.initSign(privateKey); 
		signature.update(msg.getBytes()); 
		
		return signature.sign(); 	
	} 
	
	public static boolean verify(PublicKey rsaPublicKey,String msg,byte[] signatureByte) throws Exception { 
		Signature signature = Signature.getInstance("MD5withRSA"); 
		signature = Signature.getInstance("MD5withRSA"); 
		signature.initVerify(rsaPublicKey); 
		signature.update(msg.getBytes()); 
		
		return signature.verify(signatureByte); 
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
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA"); 
		keyPairGenerator.initialize(1024); 
		KeyPair keyPair = keyPairGenerator.generateKeyPair(); 
		PublicKey rsaPublicKey = (RSAPublicKey)keyPair.getPublic(); 
		PrivateKey rsaPrivateKey = (RSAPrivateKey)keyPair.getPrivate(); 
		
		String msg = "message encrypted in java";
		
		byte[] signature = RSASign.sign(rsaPrivateKey, msg); 
		
		// System.out.println("消息明文：" + msg); 
		// System.out.println("签名：" + new String(signature)); 
		// boolean flag = RSASign.verify(rsaPublicKey, msg, signature); 
		// System.out.println("验签结果：" + flag);
		
		System.out.println("Plain Text:" + msg);
		System.out.println("Plain Text Length:" + msg.length());
		
		System.out.println("RSASigned Text:" + new String(signature));
		System.out.println("RSASigned Text Length:" + signature.length);
		
		System.out.println("RSASigned Text:" + bytesToHexFun3(signature));		
		
		boolean flag = RSASign.verify(rsaPublicKey, msg, signature); 
		System.out.println("Verified Signature:" + flag);
	} 
}
