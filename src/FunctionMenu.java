import java.util.Scanner;

public class FunctionMenu {
    public static void main(String[] args){
        //test
        Scanner in = new Scanner(System.in);
        menu(in);
    }


    public static void menu(Scanner in){
        boolean active = true;
        do{
            clearScreen();
            
            System.out.println("--------------------------------------------");
            System.out.println("               FUNCTION MENU");
            System.out.println("--------------------------------------------");
            System.out.println(" Note: type \"404\" at anytime to cancel");
            //DISPLAY THE OPTIONS
            /////////////////////////////
            System.out.println("--------------------------------------------");
            System.out.print("->");
            String choice = in.nextLine();
            try{
                int num = Integer.parseInt(choice);
                switch(num){
                    case 1:
                        //call the function
                        break;
                    case 2:
                        //call the function
                        break;
                    //case 3: exit the program
                    case 3:
                    case 404:
                        return;
                    default:
                        clearScreen();
                        System.out.println("--------------------------------------------");
                        System.out.println("                    ERROR");
                        System.out.println("--------------------------------------------");
                        System.out.println(  "           Invalid choice," + num + 
                                                         " \nPlease try again.");
                        System.out.println("--------------------------------------------");
                        System.out.print("Press enter to continue...");
                        in.nextLine();
                        break;
                }
            }catch(NumberFormatException e){
                //if not number 
                clearScreen();
                System.out.println("--------------------------------------------");
                System.out.println("                    ERROR");
                System.out.println("--------------------------------------------"); 
                System.out.println("            Please enter a number.");
                System.out.println("--------------------------------------------");
                System.out.print("Press enter to continue...");
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
