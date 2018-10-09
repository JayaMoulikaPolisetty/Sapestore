package com.sapient.sapestore.encrytionservice;
/*
import javax.crypto.Cipher;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.commons.codec.binary.Base64;*/

public class Crypto {/*
	private final String Constant = "792F423F4528482B";
	private Logger logger = LoggerFactory.getLogger(Crypto.class);

	public String encrypt(String value) {
		try {
			IvParameterSpec iv = new IvParameterSpec("7G|Lu9s$!0fhYrfN".getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(Constant.getBytes("UTF-8"), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
			byte[] encrypted = cipher.doFinal(value.getBytes());
			return new String(Base64.encodeBase64(encrypted));
		} catch (Exception e) {
			logger.error("Got Exception :", e);
		}
		return "";
	}

	public String decrypt(byte[] encrypted) {
		try {
			IvParameterSpec iv = new IvParameterSpec("7G|Lu9s$!0fhYrfN".getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(Constant.getBytes("UTF-8"), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));
			return new String(original);
		} catch (Exception e) {
			logger.error("Got Exception :", e);
		}
		return "";
	}
*/
}
