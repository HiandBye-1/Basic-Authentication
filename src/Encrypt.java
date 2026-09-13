import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//make the password encrypted before saving into database
public class Encrypt {
    public static void main(String[] args){
        System.out.println(encryptedPass("password"));
    }

    public static String encryptedPass(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPassword = encoder.encode(password);
        return hashedPassword;
    }
}

///////finish
/// 