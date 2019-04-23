package com.group_2.milestonePlanner.auth;
import org.apache.commons.codec.digest.DigestUtils;

public class PasswordHash {
	public static String createHash(String password) {
		String hash = DigestUtils
				.md5Hex(password).toUpperCase();
		return hash;
	}

	public static boolean validatePassword(String password, String hash){
		return hash.equals(createHash(password));
	}
}
