import java.util.Scanner;
public class LoginMenu {
    public static void main(String[] args){
        menu(new Scanner(System.in));
    }

    //create a interface for login menu
    public static void menu(Scanner in){
        boolean active = true;
        do{
            clearScreen();
            System.out.println("--------------------------------------------");
            System.out.println("               LOGIN MENU");
            System.out.println("--------------------------------------------");
            System.out.println(" Note: type \"404\" at anytime to cancel");
            System.out.println(" Note: type \"otp\" to use one-time password login");
            //user
            System.out.print("\n Username: ");
            String username = in.nextLine();
            if(username.equals("404")) return;
            //if user wants to use one time password login
            else if(username.equals("otp")){
                OneTimePassMenu.menu(in);
                return;
            }


            //password
            System.out.print(" Password: ");
            String password = in.nextLine();
            if(password.equals("404")) return;
            else if(password.equals("otp")){
                OneTimePassMenu.menu(in);
                return;
            }
            
            //if found in database 
            clearScreen();
            if(LoginDatabase.checkLogin(username, password)){
                System.out.println("--------------------------------------------");
                System.out.println("              Login successful!");
                System.out.println("--------------------------------------------\n");
                //realign whole prhase to be center at all time with printf
                int padding = (40 - username.length()) / 2;
                System.out.println("                 Welcome,");
                System.out.printf("%s%s%s\n", " ".repeat(padding), username, " ".repeat(padding));
                System.out.println();
                System.out.println("--------------------------------------------");
                System.out.println("Press Enter to continue...");
                in.nextLine();
                active = false;
            }else{
                System.out.println("--------------------------------------------");
                System.out.println("               Login failed!");
                System.out.println("--------------------------------------------\n");
                System.out.println("     Username or password is incorrect.\n");
                System.out.println("--------------------------------------------");
                System.out.println("Press Enter to continue...");
                in.nextLine();
            }


        }while(active);
    }

    public static void clearScreen(){
        //clear the console
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}
