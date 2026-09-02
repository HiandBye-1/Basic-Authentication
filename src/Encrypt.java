import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//make the password encrypted before saving into database
public class Encrypt {
    public static void main(String[] args){
    }

    public static String encryptedPass(String password){
        try {
            //create sha256 machine
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            //hash the password into raw bytes and mix it up
            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));

            //convert hash into hexstring
            StringBuilder hexString = new StringBuilder();

            //for each byte in the hash, convert it to hex and append hex string
            for (byte b : hash) {
                //convert byte to hex string
                String hex = Integer.toHexString(0xff & b);

                if(hex.length() == 1) hexString.append('0');

                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
///////finish
/// 