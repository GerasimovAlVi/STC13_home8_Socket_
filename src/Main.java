import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Server_Client> arrayListSocket = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        try{
            ServerSocket serverSocket = new ServerSocket(4888);
            System.out.println("Сервер стартовал!");

            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("Новый участник присоединился к чату!");
                Server_Client server_client = new Server_Client(socket);
                arrayListSocket.add(server_client);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
