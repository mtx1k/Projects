package ua.nure.shekhovtsov.Practice3;

import java.nio.charset.Charset;
import java.security.*;

public class Part4 {
	public static String hash(String input, String algorithm)
			throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance(algorithm);
		digest.update(input.getBytes(Charset.defaultCharset()));
		byte[] hash = digest.digest();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			buffer.append(Integer.toHexString(hash[i])).append(" ");
		}
		return buffer.toString().replaceAll("ffffff", "");
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println(hash("password", "SHA-256"));
		System.out.println(hash("passwort", "SHA-256"));
	}
}