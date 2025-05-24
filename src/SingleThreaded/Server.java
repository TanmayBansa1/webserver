package SingleThreaded;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private void run() throws IOException{

            ServerSocket serverSocket = new ServerSocket(8000);
            serverSocket.setSoTimeout(10000);
            while(true){
                try{
                    System.out.println("Server is running on port 8000");
                    Socket acceptedConnection = serverSocket.accept();
                    System.out.println("Accepted connection from " + acceptedConnection.getRemoteSocketAddress());
                    PrintWriter out = new PrintWriter(acceptedConnection.getOutputStream());
                    BufferedReader inp = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
                    out.println("HTTP/1.1 200 OK from the server");
                }catch(IOException e){
                    e.printStackTrace();
                }
            }

    }
    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
