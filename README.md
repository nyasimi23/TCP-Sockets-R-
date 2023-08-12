# TCP Echo Server and Client
This repository contains a simple example of a TCP Echo Server and Client implementation in Java. The TCP Echo Server listens for incoming client connections, echoes back messages sent by clients, and keeps track of the number of messages received. The TCP Echo Client connects to the server and allows a user to send messages to the server for echoing.

## Server (`TCPEchoServer.java`)

The server code (`TCPEchoServer.java`) creates a TCP server that listens on a specified port for incoming client connections. It performs the following steps:

1. **Opening Port and Initializing ServerSocket:**
     - Creates a ***ServerSocket object*** to listen for incoming connections on a specified port.
       ```
       serverSocket = new ServerSocket(PORT);  
       ```

2. **Waiting for Client Connection**
     - Puts the server into a waiting state, waiting for a client to connect.
       ```
        Socket link = serverSocket.accept(); 
       ```
     - When a client connects, a Socket object is created to represent the client connection.

3. **Setting Up Input and Output Streams:**
     - Creates input and output streams for communication with the connected client.

       ```
       Scanner input = new Scanner(link.getInputStream());
       PrintWriter output = new PrintWriter(link.getOutputStream(),true);
       ```

4. **Send and receive data**
     - We simply use method `nextLine` for receiving data and method `println` for sending data.


5. **Close the connection**
     - Closes the connection with the client.

       ```
       link.close();
       ```


## Client (`TCPEchoClient.java`)

1. **Establish a connection to the server**
      - We create a ***Socket object***, supplying its constructor with the following two arguments: ***server’s IP address*** and ***port number***

        ```
        host = InetAddress.getLocalHost();
        PORT = 1234
        Socket link = new Socket(host,PORT);
        ```
2. **Set up input and output streams**
      - Creates input and output streams for communication with the server.

         ```
         Scanner input = new Scanner(link.getInputStream());
         PrintWriter output = new PrintWriter(link.getOutputStream(),true);
         ```

3. **Send and receive data**
      - Takes user input messages and sends them to the server for echoing.
      - Receives the echoed messages from the server and displays them.

4. **Close the connection**
      - Closes the connection with the server.

        ```
        link.close();
        ```
  
       