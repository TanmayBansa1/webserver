package SingleThreaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public void run() throws IOException {
        InetAddress address = InetAddress.getByName("localhost");
        Socket socket = new Socket(address, 8000);
        PrintWriter toServer = new PrintWriter(socket.getOutputStream());
        BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        toServer.println("GET / HTTP/1.1 from the client");
        String line = fromServer.readLine();
        System.out.println("Message from the server:" +line);
        toServer.close();
        fromServer.close();
        socket.close();
    }

    public static void main(String[] args)  {

        try{
            Client client = new Client();
            client.run();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
