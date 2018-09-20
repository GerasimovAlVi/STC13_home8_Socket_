import java.io.*;
import java.net.Socket;

class Server_Client extends Thread {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    Server_Client(Socket socket) throws IOException {
        this.socket = socket;
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();
    }
    public void run(){
        String message;
        try{
            message = bufferedReader.readLine();
            bufferedWriter.write(message + "\n");
            bufferedWriter.flush();
            while (true) {
                message = bufferedReader.readLine();
                System.out.println("Сообщение от " + message);

                for (Server_Client i : Main.arrayListSocket) {
                    i.bufferedWriter.write(message + "\n");
                    i.bufferedWriter.flush();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("Участник покинул чат!");
        }
    }
}
