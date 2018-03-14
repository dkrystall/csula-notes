import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.net.*;


/**
 * javaRefreshse
 * Created by davidkrystall on 2/21/18.
 * <p>
 * <p>
 * (c) ontometrics 2015, All Rights Reserved
 */
public class GuoSocketClient {
    public static void main(String[] args)

    {

        try {

            Socket communicationSocket = new Socket(InetAddress.getLocalHost().getHostAddress(), 1625);

            ObjectOutput objOutput = new ObjectOutputStream(communicationSocket.getOutputStream());

            ObjectInput objInput = new ObjectInputStream(communicationSocket.getInputStream());

            while (true)

            {

                Scanner sc = new Scanner(System.in);

                String inString = sc.nextLine();

                objOutput.writeObject(inString);

                String tmp = (String)objInput.readObject();

                System.out.println("server --> " + tmp);

            }

        } catch (Exception e) {

        }

    }
}
