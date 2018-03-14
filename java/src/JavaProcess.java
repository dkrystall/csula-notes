import java.io.File;
import java.util.Scanner;

/**
 * javaRefreshse
 * Created by davidkrystall on 2/14/18.
 * <p>
 * <p>
 * (c) ontometrics 2015, All Rights Reserved
 */
public class JavaProcess {
    public static void main(String[]args) {
        try{
            Process process = Runtime.getRuntime().exec("Notes.exe");
        }
        catch(Exception e) {
        }

        Scanner in = new Scanner(System.in);
        String file = in.nextLine();
        File f = new File(file);
    }
}
