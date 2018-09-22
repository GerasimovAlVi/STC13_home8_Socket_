import java.io.*;
import java.net.Socket;

class ServerClient extends Thread {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    ServerClient(Socket socket) throws IOException {
        this.socket = socket;
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();
    }
    public void run(){
        String message;
        try{
            while (true) {
                message = bufferedReader.readLine();
                if(message.equals("quit")){
                    throw new Exception();
                }
                System.out.println("Сообщение от " + message);
                for (ServerClient i : Main.arrayListSserverClient) {
                    i.bufferedWriter.write(message + "\n");
                    i.bufferedWriter.flush();
                }
            }
        }catch(Exception e){
            Main.arrayListSserverClient.remove(this);
            System.out.println("Участник покинул чат!");
            try {
                bufferedReader.close();
                bufferedWriter.close();
                socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
