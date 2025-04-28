import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    public static ArrayList<MultiThread> clientThreads = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started on port 5000");

        // Connect clients
        while (true) {
            Socket clientSocket = serverSocket.accept();

            MultiThread multiThread = new MultiThread(clientSocket);
            clientThreads.add(multiThread);

            Thread thread = new Thread(multiThread);
            thread.start();
        }
    }
}
