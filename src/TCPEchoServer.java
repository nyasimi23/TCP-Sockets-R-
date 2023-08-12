//Server that echoes back clients messages
//At the end of a dialogue,sends a message indicating
//the number of messages received.UsesTCP

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPEchoServer{
    private static ServerSocket serverSocket;
    private static final int PORT=1234;

    public static void main(String[] args) {
        System.out.println("Opening port...");

        try {
            // Create a ServerSocket object [STEP 1]
            serverSocket = new ServerSocket(PORT);            
        } catch (IOException ioEX) {
            System.out.println("Unable to attach to port!");
            System.exit(1);
        }

        do {
            handleclient();
        } while (true);
    }

    private static void handleclient() {
        // 
        Socket link = null;

        try {
            // Put the server into a waiting state [STEP 2]
            link = serverSocket.accept();  
            
            // Set up input and output streams [STEP 3]
            Scanner input = new Scanner(link.getInputStream());
            PrintWriter output = new PrintWriter(link.getOutputStream(),true);

            int numMessages=0;
            String message = input.nextLine();

            while (!message.equals("***CLOSE***")) {
                System.out.println("Message received");

                numMessages++;
                output.println("Message " + numMessages + ":" + message); 
                message = input.nextLine();
                
            }

            output.println(numMessages +" messagesreceived.");


        } catch (IOException ioEX) {
            ioEX.printStackTrace();
        } finally {
            try {
                System.out.println("\n * Closing connection... ");
                link.close();
                
            } catch (Exception e) {
                System.out.println("Unable to disconnect!");
                System.exit(1);
            }
        }
    }
}