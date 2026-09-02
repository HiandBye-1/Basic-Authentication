import java.util.Scanner;
public class RegisterMenu {
    public static void main(String[] args){
        menu(new Scanner(System.in));
    }

    //create a interface for register menu
    public static void menu(Scanner in){
        clearScreen();
        boolean active = true;
        do{
            System.out.println("--------------------------------------------");
            System.out.println("              REGISTER MENU");
            System.out.println("--------------------------------------------");
            System.out.println(" Note: type \"404\" at anytime to cancel");
            //user
            System.out.print("\n Username: ");
            String username = in.nextLine();
            if(username.equals("404")) return;
            //password
            System.out.print(" Password: ");
            String password = in.nextLine();
            if(password.equals("404")) return;

            //confirm password
            System.out.print(" Confirm Password: ");
            String confirmPassword = in.nextLine();
            if(confirmPassword.equals("404")) return;

            //confirm password
            if(!password.equals(confirmPassword)){
                do{
                    clearScreen();
                    System.out.println("--------------------------------------");
                    System.out.println("  Passwords do not match! Try again.");
                    System.out.println("--------------------------------------");
                    System.out.println(" Note: type \"404\" at anytime to cancel");
                    System.out.println("Username: " + username);
                    System.out.print("Password: ");
                    password = in.nextLine();
                    if(password.equals("404")) break;
                    System.out.print("Confirm Password: ");
                    confirmPassword = in.nextLine();
                    if(confirmPassword.equals("404")) break;
                //if password and confirm password doesn't match, keep asking for confirm password until it matches or user types 404 to cancel
                }while(!confirmPassword.equals(password) && !confirmPassword.equals("404"));
                }

            //if user types 404 to cancel
            if (password.equals("404")) return;
            RegisterDatabase me = new RegisterDatabase(username, password);
            int result = me.checkDuplicateUsername();
            
            //if result is 1, then the username already exists and the user will be prompted to enter a new username. 
            if(result ==1){
                System.out.println("Press Enter to continue...");
                in.nextLine();
                clearScreen();
            //If result is 0, then the registration was successful and the user will be taken back to the main menu.
            }else{
                me.saveToDatabase();
                System.out.println("Press Enter to continue...");
                in.nextLine();
                clearScreen();
                active = false;
            }


        }while(active);
    }

    public static void clearScreen(){
        //clear the console
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}
