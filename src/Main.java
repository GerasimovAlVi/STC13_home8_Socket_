import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<ServerClient> arrayListSserverClient = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        try(ServerSocket serverSocket = new ServerSocket(4888);){
            System.out.println("Сервер стартовал!");

            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("Новый участник присоединился к чату!");
                ServerClient serverClient = new ServerClient(socket);
                arrayListSserverClient.add(serverClient);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
