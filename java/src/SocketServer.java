import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * SocketServer
 * Created by davidkrystall on 9/28/18.
 */
public class SocketServer {

    public static void main(String[] args) {
        try (
                ServerSocket serverSocket = new ServerSocket(1625);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
        ) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
