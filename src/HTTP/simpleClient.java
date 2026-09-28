package HTTP;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class simpleClient {
    public static void main(String[] args) throws Exception{

        HttpClient client = HttpClient.newHttpClient();

        

        //client send the post request
        String json = "{\"name\":\"Mist\", \"id\": }";
        HttpRequest request = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(json)).uri(new URI("http://localhost:8000/employee")).build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        json = "{\"name\":\"hate\", \"id\": 12}";
        request = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(json)).uri(new URI("http://localhost:8000/employee")).build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        //server response the get request
        request = HttpRequest.newBuilder().GET().uri(new URI("http://localhost:8000/employee/100")).build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        

    }
}
