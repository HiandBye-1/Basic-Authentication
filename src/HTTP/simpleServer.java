package HTTP;
import com.sun.net.httpserver.HttpServer;
import java.net.*;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class simpleServer {

    public static void main(String[] args) throws Exception{
        HashMap<Integer, Employee> employees = new HashMap<Integer, Employee>();
        ObjectMapper mapper = new ObjectMapper();

        
        

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        
        server.createContext("/employee", exchange ->{
            
            //get
            if(exchange.getRequestMethod().toLowerCase().equals("get")){
            String[] path = exchange.getRequestURI().toString().split("/");
            String response = "";
            if(path.length == 2){// /employee
                response = mapper.writeValueAsString(employees.values());
            }else if(path.length == 3){// /employee/id
                try{
                    response = mapper.writeValueAsString(employees.get(Integer.parseInt(path[2])));
                }catch(NumberFormatException e){//400 = bad request
                    exchange.sendResponseHeaders(400, -1);
                    exchange.close();
                    return;
                }
                if(response.equals("null")){
                    exchange.sendResponseHeaders(404, -1);
                    exchange.close();
                    return;
                }
            }else{
                exchange.sendResponseHeaders(404, -1);
                exchange.close();
                return;
            }
            
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            exchange.getResponseBody().write(response.getBytes());
            exchange.getResponseBody().close();


            //post
            }else if(exchange.getRequestMethod().toLowerCase().equals("post")){

                Scanner in = new Scanner(exchange.getRequestBody());
                String oneLine = "";
                String original = "";
                while(in.hasNextLine()){
                    String line = in.nextLine();
                    oneLine += line;
                }
                try{
                    Employee emp = mapper.readValue(oneLine, Employee.class);
                    employees.put(emp.getID(), emp);
                    System.out.println("Employee Created!");
                    System.out.println("ID: " + emp.getID());
                    System.out.println("Name: " + emp.getName());
                    original = mapper.writeValueAsString(employees.values());
                }catch(Exception e){
                    exchange.sendResponseHeaders(400, -1);
                    exchange.close();
                    in.close();
                    return;
                }
                
                
                exchange.sendResponseHeaders(201, original.getBytes().length);
                exchange.getResponseBody().write(original.getBytes());

                exchange.getResponseBody().close();
                exchange.close();
                in.close();

            }else{
                exchange.sendResponseHeaders(405, -1);
                exchange.close();
            }


        });

        server.start();

        
    }
}
