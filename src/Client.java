import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        try(Socket socket = new Socket("127.0.0.1",4888);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){

            Listener listener = new Listener(socket);
            listener.start();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите свое имя: ");
            String nickname = scanner.nextLine();
            System.out.println("Привет " + nickname);
            String message = "";
            while(true){
                message = scanner.nextLine();
                if(message.equals("quit")){
                    break;
                }
                    bufferedWriter.write(nickname + ": " + message);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
