package commonLLDQuestions.consistentHashing.strategy;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5HashingStrategy implements HashingStrategy{

    @Override
    public int generateHash(String key) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(key.getBytes());
            return ((bytes[0] & 0xFF) << 24) |
                    ((bytes[1] & 0xFF) << 16) |
                    ((bytes[2] & 0xFF) << 8) |
                    (bytes[3] & 0xFF);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 not supported", e);
        }
    }
}
