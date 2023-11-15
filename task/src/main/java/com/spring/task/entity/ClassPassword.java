package com.spring.task.entity;
import org.apache.commons.codec.binary.Hex;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ClassPassword {
	public static String getPassword(String phoneNo) {
		MessageDigest algorithm;

		try {
			algorithm = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("SHA-1 algorithm not found!");
		}
		byte[] digest = algorithm.digest(phoneNo.getBytes());
		return new String(Hex.encodeHex(digest));
	}


	}
