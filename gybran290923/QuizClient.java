
package gybran290923;
import java.io.*;
import java.net.*;
/**
 *
 * @author Gybran
 */
public class QuizClient {
    public static void main(String args[]) {
        try {
            while(true){            
       
                Socket client = new Socket(InetAddress.getLocalHost(),1234);
                InputStream clientIn = client.getInputStream();
                OutputStream clientOut = client.getOutputStream();
                PrintWriter pw = new PrintWriter(clientOut, true);
                BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Client : ");
                pw.println(stdIn.readLine());
                String server_msg = br.readLine();
                System.out.println("Server : " + server_msg);
                pw.close();
                br.close();
                client.close();
            }
        } catch (ConnectException ce) {
            System.out.println("Cannot connect to the server.");
        } catch (IOException ie) {
            System.out.println("I/O Error.");
        }
    }
}