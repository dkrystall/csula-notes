import java.io.*;
import java.net.*;

/**
 * SocketClient
 * Created by davidkrystall on 9/28/18.
 */

public class SocketClient {

    public static void main(String[] args) {

        try (
            Socket socket = new Socket(InetAddress.getLocalHost(), 1625);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
        ) {
            BufferedReader stdIn =
                    new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;

            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("Bye."))
                    break;

                fromUser = stdIn.readLine();
                if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + e.getLocalizedMessage().toString());
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    e.getLocalizedMessage().toString());
            System.exit(1);
        }
    }
}