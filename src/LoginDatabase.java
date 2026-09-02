import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDatabase{

    //check if the username and password match with the mysql database and return T/F
    public static boolean checkLogin(String username, String password){
        try{
            String query = "SELECT * FROM users WHERE user_name = ? and user_password = ?";
            PreparedStatement pst = DBconnect.getConnection().prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, Encrypt.encryptedPass(password));
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
//////////TO BE CONTINUED WITH ONE TIME PASSWORD