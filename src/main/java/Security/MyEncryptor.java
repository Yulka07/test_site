package Security;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Julia on 21.05.2016.
 */
public class MyEncryptor {
    public static String getEncryptedPassword(String password)throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.update(password.getBytes("utf8"));
        byte[] digestBytes = digest.digest();
        return DatatypeConverter.printHexBinary(digestBytes);
    }
}
