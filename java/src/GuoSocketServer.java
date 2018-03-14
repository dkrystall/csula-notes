import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * javaRefreshse
 * Created by davidkrystall on 2/21/18.
 * <p>
 * <p>
 * (c) ontometrics 2015, All Rights Reserved
 */
public class GuoSocketServer extends Thread{
    public static void main(String[] args) {

        try

        {

            ServerSocket serverSocket = new ServerSocket(1625);

            Socket communicationSocket = serverSocket.accept();

            ObjectInput objInput = new ObjectInputStream(communicationSocket.getInputStream());

            ObjectOutput objOutput = new ObjectOutputStream(communicationSocket.getOutputStream());
            System.out.println("Server is running on: "+ InetAddress.getLocalHost().getHostAddress());

            while (true)

            {

                String tmp = (String)objInput.readObject();

                System.out.println("Client --> " + tmp);

                Scanner sc = new Scanner(System.in);

                String inString = sc.nextLine();

                objOutput.writeObject(inString);

            }

        } catch (Exception e)

        { }

    }
}
