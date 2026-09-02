
import java.io.*;
import java.util.*;
public class basicFunction {

    public static void main(String[] args) throws Exception{
        //test
        priorTask();
    }

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static String countStuffs(String input){
        String words = input; 
        int wordsCount = 0;
        int characterCount = 0;
        int spaceCount = 0;
        int specialCount = 0;
        int numberCount = 0;
        boolean isWord = true;
        
        if (words.length() == 0);
        else{

            for(int i = 0; i < words.length(); i++){
                char current = words.charAt(i);
                if(Character.isLetter(current)){
                    characterCount++;
                    isWord =true;
                }
                else if(Character.isDigit(current)){
                    numberCount++;
                    isWord = true;
                }
                else if(Character.isSpaceChar(current)){
                    spaceCount++;
                    if(isWord) wordsCount++;
                    isWord = false;
                }
                else{
                    specialCount++;
                    isWord = true;
                }if(i == words.length() - 1 && isWord) wordsCount++;
            }
        }
        return "Words: " + wordsCount + "\nCharacters: " + characterCount + "\nSpaces: " + spaceCount + "\nSpecial Characters: " + specialCount + "\nNumbers: " + numberCount;
    }
    public static void read(String file) throws Exception{
        Scanner in = new Scanner(new File(file));

        System.out.println("Reading FILE "+file);
        while(in.hasNextLine()){
            System.out.println(in.nextLine());
        }
        in.close();

    }
    
    public static void write(String file, String content) throws Exception{
        PrintWriter out = new PrintWriter(new File(file));
        out.println(content);
        out.close();
    }

    public static void priorTask(){
        Scanner in = new Scanner(System.in);
        boolean active = true;
        HashMap<String, Integer> list = new HashMap<String, Integer>();
        String name="404";
        int time=404;
        int totalTime=0;
        boolean done = false;

        //inputting tasks and times
        do{
            if(!done){
                clearScreen();
                System.out.println("Whats the total available time to complete tasks: ");
                try{
                    totalTime = Integer.parseInt(in.nextLine());
                    if(totalTime == 404){
                        active = false;
                        break;
                    }else if(totalTime <= 0){
                        clearScreen();
                        System.out.println("Invalid input, please enter an appropriate number for time");
                        System.out.println("Press enter to continue...");
                        in.nextLine();
                        continue;
                    }
                }catch(Exception e){
                    clearScreen();
                    System.out.println("Invalid input, please enter a number for time and no task was saved.");
                    System.out.println("Press enter to continue...");
                    in.nextLine();
                    continue;
                }
                done = true;
            }


            clearScreen();
            System.out.println("list of tasks: " + list);
            name = "404";
            time = 404;
            totalTime = 0;
            System.out.println("Whats the task name? '404' to exit");
            name = in.nextLine();
            if (name.equals("404")){
                active = false;
                break;
            }else if(list.containsKey(name)){//if name already exist
                clearScreen();
                System.out.println("Name have already exist, please choose a new name");
                System.out.println("Press enter to continue");
                in.nextLine();
                continue;
            }


            System.out.println("Whats the time of the task? '404' to exit");
            try{
                time = Integer.parseInt(in.nextLine());
                if(time == 404){
                    active = false;
                    break;
                }
            }catch(Exception e){
                clearScreen();
                System.out.println("Invalid input, please enter a number for time and no task was saved.");
                System.out.println("Press enter to continue...");
                in.nextLine();
                continue;
            }

            //if the user didn't input time correctly, the task will not be saved and the user will be prompted to input again.
            //this is to prevent the user from inputting a task with no time, which would be invalid.
            if(name.equals("404") || time == 404){
                active = false;
                break;
            }

            //only work if the user inputted a valid task name and time, otherwise the task will not be
            // saved and the user will be prompted to input again.
            list.put(name, time);
            System.out.println("Task saved: " + name + " with time: " + time);
            System.out.println("Press enter to continue...");
            in.nextLine();
            clearScreen();
            
        }while(active);
        System.out.println("best time to complete tasks: "+ (rearrange(list, totalTime, list.size())));
        in.close();

    //calculate the highest time that tasks can be completed that does not exceed the total time in dp style
    }public static int rearrange(HashMap<String, Integer> list, int totalTime, int size){//goes with priorTask()
        if(totalTime == 0 || size == 0) return 0;
        int[] dp = new int[totalTime + 1];
        for(int i = 0; i < size; i++){//traverse each task
            for(int j = totalTime; j >= list.get(list.keySet().toArray()[i]); j--){//task times less than or equal to totalTime
                dp[j] = Math.max(dp[j], dp[j - list.get(list.keySet().toArray()[i])] + list.get(list.keySet().toArray()[i]));
            }
        }
        return dp[totalTime];
    }


}