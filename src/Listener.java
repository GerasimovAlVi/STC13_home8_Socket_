import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Listener extends  Thread {
    private Socket socket;

    public Listener(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))){

            while(true){
                System.out.println(bufferedReader.readLine());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
