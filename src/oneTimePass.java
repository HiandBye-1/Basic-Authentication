public class oneTimePass {
    public static void main(String[] args){
    }
    //generate a random one time password with 10 characters
    public static String generateOneTimePass(){
        String storage = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789;[]{}!@#$%^&*()_+-=~`";
        String pass = "";
        String current = "";
        for(int i = 0; i < 10; i++){
            current = storage.charAt((int)(Math.random() * storage.length()))+"";
            pass += current;
        }
        
        return pass;
    }
}
//////finish
/// 
