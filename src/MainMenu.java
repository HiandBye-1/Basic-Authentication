import java.util.*;

//graphics related only for menu
public class MainMenu {
    public static void main(String [] args){
        menu();

    }

    public static void menu(){
        //create a interface for login menu
        boolean active = true;
        Scanner in = new Scanner(System.in);
        while(active){
            clearScreen();
            System.out.println("----------------------------");
            System.out.println("        LOGIN MENU");     
            System.out.println("----------------------------");
            System.out.println(" 1. Login                  ");
            System.out.println(" 2. Register               ");
            System.out.println(" 3. Exit                   ");
            System.out.println("----------------------------");
        

            System.out.print("-> ");
            String input = in.nextLine();

        //try if input is a number and if not allow enter input as string
        try {
            int choice = Integer.parseInt(input);
            switch(choice){
                //login
                case 1:
                    LoginMenu.menu(in);
                    break;
                //register
                case 2:
                    RegisterMenu.menu(in);
                    break;
                //exit
                case 3:
                    active = false;
                    break;
                default:
                    showError(in, input);
                    break;
            }
        } catch(NumberFormatException e){
            switch(input.toLowerCase()){
                case "login":
                    break;
                case "register":
                    break;
                case "exit":
                    break;
                default:
                    showError(in, input);
                    break;
            }
        }
    }
        
    }

    public static void clearScreen(){
        //clear out the screen
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void showError(Scanner in, String input){
        clearScreen();
        System.out.println("\n----------------------------"); 
        System.out.println("       Invalid input");
        System.out.println("----------------------------");
        System.out.println(" You entered: " + input);
        System.out.println("----------------------------");
        System.out.println("Press ENTER to continue...");
        in.nextLine();
        
    }
    
}