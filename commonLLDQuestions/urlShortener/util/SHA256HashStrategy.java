package commonLLDQuestions.urlShortener.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256HashStrategy implements HashStrategy{


    @Override
    public String generateHash(String longUrl) {
        try {
            // Create a SHA-256 digest
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Apply the digest to the input string
            byte[] hashBytes = digest.digest(longUrl.getBytes());

            // Convert the byte array into a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0'); // pad with leading zero
                hexString.append(hex);
            }

            return hexString.toString().substring(0,8);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found.", e);
        }
    }
}
