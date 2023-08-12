import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPEchoClient {
    private static InetAddress host;
    private static final int PORT=1234;


    public static void main(String[] args) {
        try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException uneX) {
            System.out.println("Host ID not found!");
            System.exit(1);
        }
        accessServer();
    }


    private static void accessServer() {
        // Create a socket object [STEP 1]
        Socket link = null;

        try {
            // Supply its constructor with Server Ip address and Port number [STEP 1]
            link = new Socket(host,PORT);

            // Set up input and output streams [STEP 2]
            Scanner input = new Scanner(link.getInputStream());
            PrintWriter output = new PrintWriter(link.getOutputStream(),true);

            try (Scanner userEntry = new Scanner(System.in)) {
                String message,response;

                do {
                    System.out.println("Enter a message:");
                    message = userEntry.nextLine();

                    output.println(message); 
                    response = input.nextLine();

                    System.out.println("\nSERVER>" + response);
                } while (!message.equals("***CLOSE***"));
            }


        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        } finally {
            try {
                System.out.println("\n Closing connection...");
                link.close();
            } catch (IOException ioEx) {
                System.out.println("Unable to disconnect!");
                System.exit(1);
            }
        }
    }

}
