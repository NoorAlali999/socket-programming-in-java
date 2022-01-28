# socket-programming-in-java
This project presents an introduction to sockets programming over TCP/IP networks. I wrote a client/server application in Java, Multiple Clients can communicate with the Server, Each Client must provide their ID with a circle radius, and the Server replies to the client with the circle area.
How to run the application:
1. Open a terminal window for the server and a terminal for each client.
2. In your terminal, navigate to the directory where your files are located.
3. In the server terminal, to compile the server program run:
`$ javac PacketReceiver.java`
Then to start the server run:
`$ java PacketReceiver`
This will establish the connection and the server will start waiting for clients.
4. In a new terminal, to compile the client program run:
`$ javac PacketSender.java`
Then to start the client run:
`$ java PacketSender`
This will connect the client with the connection.
5. Now the client is able to enter the radius and send it to the server, the server will receive it, confirm the receiving, calculate the area and send it to the client.
6. If you want to connect with multiple clients at the same time you should open a new terminal for each client and run:
`$ java PacketSender`
Then you will be able to send data from the client and server will confirm connected with the new client.
7. To close the connection, send “Close” from the client side and the server will confirm closing the connection and decrease the clients counter.
