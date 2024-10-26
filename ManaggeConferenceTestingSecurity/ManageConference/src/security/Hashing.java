package security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class Hashing {
	
	
	
	
	public static String hashPassword(String password) {
	    try {
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = digest.digest(password.getBytes());
	
	        // Convert the byte array to a hexadecimal string
	        StringBuilder hexString = new StringBuilder();
	        for (byte b : hash) {
	            String hex = Integer.toHexString(0xff & b);
	            if (hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }
	
	        return hexString.toString();
	    } catch (NoSuchAlgorithmException e) {
	        // Handle exception, e.g., log it or throw a custom exception
	        e.printStackTrace();
	        return null;
	    }
	}
	
}

